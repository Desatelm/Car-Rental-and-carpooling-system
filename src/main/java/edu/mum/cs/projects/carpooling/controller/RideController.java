package edu.mum.cs.projects.carpooling.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.service.RideService;
import edu.mum.cs.projects.carpooling.service.UserService;

@Controller
@RequestMapping("ride")
public class RideController {

	@Autowired
	RideService rideService;
	@Autowired
	UserService userService;

	@GetMapping(value = "/registerform")
	public String showPostRideForm(Model model) {

		return "RidePostRegistration";
	}

	@PostMapping(value = "/registed")
	public String processRide(Ride ride, @RequestParam String email, @RequestParam String model) {

		User user = userService.getUserByemail(email);
		List<Vehicle> vehicles = user.getVicheles();
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getModel().equals(model)) {
				ride.setVehicle(vehicle);
			}
		}
		rideService.createRide(ride);
		return "RidePostRegistration";
	}


}
