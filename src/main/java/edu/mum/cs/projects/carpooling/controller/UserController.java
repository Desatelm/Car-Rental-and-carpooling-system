package edu.mum.cs.projects.carpooling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.Address;
import edu.mum.cs.projects.carpooling.domain.entity.Role;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.repository.RoleRepository;
import edu.mum.cs.projects.carpooling.service.NotificationService;
import edu.mum.cs.projects.carpooling.service.UserService;

@Controller
@Transactional

public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired	
	RoleRepository roleRepository;
	
	@Autowired
	NotificationService notificationService;
	
	@GetMapping(value = "/signup_page")
	public String adduser(Model model) {
		return "customer_registration";
	}
	
	@PostMapping(value = "/signUp")
	public String createUser(User user, Address address, @RequestParam String role) {
		
		Role role1 = roleRepository.findByRoleType(role);		
				
		user.setActive(1);
		user.setAddress(address);
		user.setRoles(role1);
		userService.createUser(user);
		try{
		notificationService.sendNotification(user);
		}
		catch(MailException e){
			System.err.println(e.getMessage());
		}
		return "redirect:/welcome";
	}
	
	@PostMapping(value = "/update")
	public String updateUser(User user, Address address, List<Vehicle> vehicles) {
		User user1 = userService.getUser(user.getName()) ;
		user1.setAddress(address);
		user1.setVehicles(vehicles);	
		userService.createUser(user1);
		return "redirect:/Confirmation";
	}
	
	@PostMapping(value = "/getProfile")
	public String getUserProfile(Model model, @RequestParam(value = "username") String username) {
		User user = userService.getUser(username);
	    model.addAttribute("user", user);		
		return "userProfile";
	}
	
	@PostMapping(value = "/deactivate")
	public String deactivateUser(User user) {
		User user1 = userService.getUser(user.getName());
		user1.setActive(0);			
		userService.createUser(user1);
		return "redirect:/home";
	}

	@PostMapping(value = "/removeUser")
	public String deletUser(User user) {					
		userService.deleteUser(user);;
		return "redirect:/home";
	}
}
