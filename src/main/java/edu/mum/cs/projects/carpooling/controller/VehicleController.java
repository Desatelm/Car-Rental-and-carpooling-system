package edu.mum.cs.projects.carpooling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.service.UserService;
import edu.mum.cs.projects.carpooling.service.VehicleService;

@Controller
@Transactional(propagation = Propagation.SUPPORTS)
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	UserService userService;
			
	@GetMapping(value = "/car_registrationForm")
	public String adduser(Model model) {
		return "carRegister";
	}
	
	@PostMapping(value = "/addVehicle")
	public String addVehicle(Vehicle vehicle, @RequestParam String email) {
		
		User user = userService.getUserByemail(email);		
		vehicle.setUser(user);
		vehicleService.creatVehicle(vehicle);		
		return "redirect:/welcome";
	}

}
