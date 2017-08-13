package edu.mum.cs.projects.carpooling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;
import edu.mum.cs.projects.carpooling.domain.entity.User;


import edu.mum.cs.projects.carpooling.service.UserService;

public class MessageController  {
	@Autowired
	UserService userService;	
	
	
	@GetMapping(value = "/confirm")
	public String addProduct(Model model) {
		return "confirm";
	}
	
	@PostMapping(value = "/addMessage")
	public String createUser(User user, MessageBox message) {
		User user1 = userService.getUser(user.getName());
		user1.setMessageBox(message);
		userService.createUser(user1);
		return "redirect:/confirm";
	}
}
