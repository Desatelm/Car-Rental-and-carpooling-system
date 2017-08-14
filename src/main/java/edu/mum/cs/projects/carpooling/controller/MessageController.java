package edu.mum.cs.projects.carpooling.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;
import edu.mum.cs.projects.carpooling.domain.entity.User;


import edu.mum.cs.projects.carpooling.service.UserService;

@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MessageController  {
	@Autowired
	UserService userService;	
	
	@GetMapping(value = "/getMessageForm/{senderEmail}")
	public String addmessage(Model model, @PathVariable String senderEmail) {
		model.addAttribute("senderEmail", senderEmail);
		return "messageForm";
	}
	
	@PostMapping(value = "/addMessage")
	public String createMessage(@RequestParam String email, @RequestParam String senderEmail, @RequestParam String message) {
				
		User user1 = userService.getUserByemail(email);
		
		MessageBox mailbox = new MessageBox();
		System.err.println("##################" + email);
		mailbox.setSenderEmail(senderEmail);
		mailbox.setMessage(message);
		//mailbox.setReceiveDate(new Date());
		System.err.println("##################" + email);
		
		List<MessageBox> messages = user1.getMessageBox();
		messages.add(mailbox);
		user1.setMessageBox(messages);
		userService.createUser(user1);
		
		return "redirect:/welcome";
	}
	
	@GetMapping(value = "/getMessages")
	public String getMessages(Model model, @RequestParam String email) {
		System.err.println("##################" + email);
		User user = userService.getUserByemail(email);
		System.err.println("##################" +user.getMessageBox().size() );
		model.addAttribute("messages", user.getMessageBox());
		System.err.println("##################" +user.getMessageBox().size() );
		return "mailbox";
	}
	
	
}
