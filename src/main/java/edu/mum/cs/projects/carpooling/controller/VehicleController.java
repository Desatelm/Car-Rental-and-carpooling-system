package edu.mum.cs.projects.carpooling.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.service.RideService;
import edu.mum.cs.projects.carpooling.service.UserService;
import edu.mum.cs.projects.carpooling.service.VehicleService;

@Controller
@Transactional
@PreAuthorize("isAuthenticated()")

public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	RideService rideService;

	@Autowired
	UserService userService;

	@GetMapping(value = "/car_registrationForm")
	public String adduser(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "carRegister";
	}
	

	@PostMapping(value = "/addVehicle")
	public String addVehicle(@Valid @ModelAttribute("vehicle") Vehicle vehicle, BindingResult bindingResult,
			@RequestParam String email, Model model, RedirectAttributes redirectAttrs) {

		if (bindingResult.hasErrors()) {
			redirectAttrs.addFlashAttribute("org.springframework.validation.BindingResult.register", bindingResult);
			redirectAttrs.addFlashAttribute("vehicle", vehicle);
			return "redirect:/car_registrationForm";
		}

		User user = userService.getUserByemail(email);
		List<Vehicle> vehicles = user.getVehicles();
		vehicle.setUser(user);
		vehicles.add(vehicle);
		vehicleService.creatVehicle(vehicle);
		model.addAttribute("vehicle", user.getVehicles());
		//redirectAttrs.addFlashAttribute("vehicle", user.getVehicles());
		return "redirect:/welcome";
	}

	@PostMapping(value = "/deleteVehicle/{id}")
	public String deleteVehicle(@PathVariable int id, @RequestParam String email, Model model,
			RedirectAttributes redirectAttrs) {
		Vehicle vehicle = vehicleService.getVehicle(id);
		User user = userService.getUserByemail(email);
		vehicle.setUser(null);
		user.getVehicles().remove(vehicle);
		
		userService.createUser(user);
		vehicleService.creatVehicle(vehicle);
		model.addAttribute("vehicle", user.getVehicles());
		//redirectAttrs.addFlashAttribute("vehicle", user.getVehicles());
		return "redirect:/welcome";
	}

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

}
