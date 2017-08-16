package edu.mum.cs.projects.carpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.service.UserService;
import edu.mum.cs.projects.carpooling.service.VehicleService;

@Controller
@Transactional
@PreAuthorize("isAuthenticated()")

public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@Autowired
	UserService userService;

	@GetMapping(value = "/car_registrationForm")
	public String adduser(Model model) {
		return "carRegister";
	}

	@GetMapping(value = "/welcom")
	public String homepage(Model model) {
		return "welcome";
	}

	@PostMapping(value = "/addVehicle")
	public String addVehicle(Vehicle vehicle, @RequestParam String email, Model model, RedirectAttributes redirectAttrs) {

		User user = userService.getUserByemail(email);
		List<Vehicle> vehicles = user.getVehicles();
		vehicle.setUser(user);
		vehicles.add(vehicle);
		vehicleService.creatVehicle(vehicle);
		model.addAttribute("vehicle", user.getVehicles());
		//redirectAttrs.addFlashAttribute("vehicle", user.getVehicles());
		return "welcome";
	}

	@PostMapping(value = "/deleteVehicle/{id}")
	public String deleteVehicle(@PathVariable int id, @RequestParam String email, Model model,RedirectAttributes redirectAttrs) {
		Vehicle vehicle = vehicleService.getVehicle(id);
		User user = userService.getUserByemail(email);
		user.getVehicles().remove(vehicle);
		vehicleService.removeVehicle(vehicle);
		model.addAttribute("vehicle", user.getVehicles());
		redirectAttrs.addFlashAttribute("vehicle", user.getVehicles());
		return "redirect:/welcome";
	}

}
