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
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vichele;
import edu.mum.cs.projects.carpooling.service.RideService;
import edu.mum.cs.projects.carpooling.service.UserService;

@Controller
@RequestMapping("ride")
public class PostRideController {

	@Autowired
	RideService rideService;
	@Autowired
	UserService userService;

	@GetMapping(value = "/registerform")
	public String showPostRide(Model model) {

		return "RidePostRegistration";
	}

	@PostMapping(value = "/registed")
	public String processRide(@RequestParam int email, Ride ride, @RequestParam String model) {
		User user1 = userService.getUserByID(email);
		List<Vichele> vichels = user1.getVicheles();
		for (Vichele vichele : vichels) {
			if (vichele.getModel().equals(model)) {
				ride.setVichele(vichele);
			}
		}
		rideService.createRide(ride);

		return "redirect:RidePostRegistration";
	}

}
