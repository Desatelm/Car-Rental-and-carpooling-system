package edu.mum.cs.projects.carpooling.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

@Controller
@RequestMapping("ride")
public class RideController {

	@Autowired
	RideService rideService;
	@Autowired
	UserService userService;

	/*
	 * public RideController() { //allRides = rideService.getAllRides(); }
	 */

	@GetMapping(value = "/registerform")
	public String showPostRideForm(Model model) {

		model.addAttribute("allRides", rideService.getAllRides());
		return "RidePostRegistration";
	}

	@PostMapping(value = "/registed")
	public String processRide(Ride ride, @RequestParam String email, @RequestParam String model, Model mod) {

		User user = userService.getUserByemail(email);
		List<Vehicle> vehicles = user.getVehicles();
		mod.addAttribute("allRides", rideService.getAllRides());
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getModel().equals(model)) {
				ride.setVehicle(vehicle);
			}
		}
		ride.setStatus(RideStatus.ONGOING);
		ride.setUser(user);
		ride.setOfferedBy(user.getEmailAddress());
		user.setRide(ride);
		userService.createUser(user);
		rideService.createRide(ride);
		return "RidePostRegistration";
	}

	@GetMapping(value = "/apply/{id}")
	public String applyForRide(@PathVariable("id") Integer id, Model model) {

		Ride ride = rideService.getRideById(id);
		User user = userService.getUserByemail(ride.getOfferedBy());

		/*
		 * List<String> seatOptions = new ArrayList<>(); for (int i = 1; i <=
		 * ride.getNoSeat(); i++) { seatOptions.add("I want to book" + i +
		 * "seat"); } model.addAttribute("seatOption", seatOptions);
		 */
		// List<User> user= ride.getUser();@PathVariable("id")
		model.addAttribute("ride", ride);
		model.addAttribute("user", user);
		return "ride-apply";
	}

	@PostMapping(value = "/booked")
	public String bookRide(@RequestParam String email, @RequestParam int postId, @RequestParam int seat) {

		User user = userService.getUserByemail(email);
		Ride ride = rideService.getRideById(postId);
		System.out.println("*******************" + user + "  and   " + ride);
		user.setRide(ride);
		ride.setNoSeat(ride.getNoSeat() - seat);
		rideService.createRide(ride);
		System.out.println("*******************");
		return "redirect:/ride/registerform";
	}
	
	@GetMapping("/offered")
	public String offeredRides(Model model)
	{
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Ride> rides = rideService.getRideByEmail(user.getEmailAddress());
		model.addAttribute("rides", rides);
		
		return "offeredride";
	}

}
