package edu.mum.cs.projects.carpooling.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.service.RideService;


@RestController
@RequestMapping("Rest")
public class RideRestControl {
	 
	@Autowired
	RideService rideService;
	
	@GetMapping(value = "/rides")
	public List<Ride> showPostRideForm(Model model) {
		 
		return rideService.getAllRides();
	}
	

}
