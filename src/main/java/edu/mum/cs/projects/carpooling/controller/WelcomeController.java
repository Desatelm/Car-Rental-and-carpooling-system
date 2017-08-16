package edu.mum.cs.projects.carpooling.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.service.UserService;
import edu.mum.cs.projects.carpooling.service.VehicleService;

@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
@PreAuthorize("isAuthenticated()")

public class WelcomeController {
    
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	UserService  userService;

	@RequestMapping("/welcome")
	public String dashboard(Model model, HttpSession session) {

		User user1 = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.getUserByID(user1.getId());
		RestTemplate restTemp = new RestTemplate();
		session.setAttribute("username", user.getLastName());
		session.setAttribute("Principal", user);
		session.setAttribute("email", user.getEmailAddress());
		session.setAttribute("myRidePost", user.getRide());
		model.addAttribute("allRides", restTemp.getForObject("http://localhost:9090/Rest/rides", ArrayList.class));
		session.setAttribute("id", user.getId());
		model.addAttribute("vehicle", user.getVehicles());
		session.setAttribute("myRidePost", user.getRide());
		model.addAttribute("userVehicle", vehicleService.getVehicleByUser(userService.getUserByID(user.getId())));
		return "welcome";
	}
}
