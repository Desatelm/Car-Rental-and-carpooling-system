package edu.mum.cs.projects.carpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.RideStatus;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.service.RideService;
import edu.mum.cs.projects.carpooling.service.UserService;
import edu.mum.cs.projects.carpooling.service.VehicleService;

@Controller
@RequestMapping("ride")
public class RideController {

	@Autowired
	RideService rideService;
	@Autowired
	UserService userService;

	@Autowired
	VehicleService vehicleService;

	@GetMapping(value = "/registerform")
	public String showPostRideFormAll(Model model) {

		model.addAttribute("allRides", rideService.getAllRides());
		return "RidePostRegistration";
	}

	

	@GetMapping(value = "/registerform/{id}")
	public String showPostRideForm(@PathVariable("id") Integer id, Model model) {

        model.addAttribute("userVehicle", vehicleService.getVehicleByUser(userService.getUserByID(id)));
		model.addAttribute("allRides", rideService.getAllRides());
		return "RidePostRegistration";
	}

	@PostMapping(value = "/registed")
	public String processRide(Ride ride, @RequestParam String email, @RequestParam int model, Model mod) {

		User user = userService.getUserByemail(email);
		List<Vehicle> vehicles = user.getVehicles();
		mod.addAttribute("allRides", rideService.getAllRides());		
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getId() == model) {
				ride.setVehicle(vehicle);
			}
		}
		ride.setStatus(RideStatus.ONGOING);
		ride.setUser(user);
		ride.setOfferedBy(user.getEmailAddress());
		user.setRide(ride);
		userService.createUser(user);
		rideService.createRide(ride);
		return "redirect:/welcome";
	}

	@GetMapping(value = "/apply/{id}")
	public String applyForRide(@PathVariable("id") Integer id, Model model) {

		Ride ride = rideService.getRideById(id);
		User user = userService.getUserByemail(ride.getOfferedBy());

		model.addAttribute("ride", ride);
		model.addAttribute("user", user);
		return "ride-apply";
	}

	@PostMapping(value = "/booked")
	public String bookRide(@RequestParam String email, @RequestParam int postId,@RequestParam int seat) {
        		
		User user = userService.getUserByemail(email);
		Ride ride = rideService.getRideById(postId);
		user.setRide(ride);
		ride.setUser(user);
		ride.setNoSeat(ride.getNoSeat() - seat);
		
		rideService.createRide(ride);
		userService.createUser(user);
		return "redirect:/welcome";
	}

	@GetMapping("/myRides")
	public String offeredRides(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Ride> rides = rideService.getRideByEmail(user.getEmailAddress());
		model.addAttribute("rides", rides);

		return "offeredride";
	}	

}
