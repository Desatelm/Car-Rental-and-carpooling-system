package edu.mum.cs.projects.carpooling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Propagation;

import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.service.VehicleService;

@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class WelcomeController {

	VehicleService vehicleService;

	@RequestMapping("/welcome")
	public String dashboard(Model model, HttpSession session) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("username", user.getLastName());
		session.setAttribute("email", user.getEmailAddress());
		// model.addAttribute("vehicle", vehicleService.getVehicleByUser(user));
		session.setAttribute("myRidePost", user.getRide());
		session.setAttribute("id", user.getId());
        System.err.println(" USER ID FROM WELCOME CONTROLER " + user.getId());
		return "welcome";
	}
}
