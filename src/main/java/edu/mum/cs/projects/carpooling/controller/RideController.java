package edu.mum.cs.projects.carpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.RideStatus;
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

	/*public RideController() {
		//allRides = rideService.getAllRides();
	}*/

	@GetMapping(value = "/registerform")
	public String showPostRideForm(Model model) {
		
		model.addAttribute("allRides",rideService.getAllRides());
		return "RidePostRegistration";
	}

	@PostMapping(value = "/registed")
	public String processRide(Ride ride, @RequestParam String email, @RequestParam String model,Model mod) {

		User user = userService.getUserByemail(email);
		List<Vehicle> vehicles = user.getVicheles();
		mod.addAttribute("allRides",rideService.getAllRides());
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getModel().equals(model)) {
				ride.setVehicle(vehicle);
			}
		}
		ride.setStatus(RideStatus.ONGOING);
		rideService.createRide(ride);
		return "RidePostRegistration";
	}

}
