package edu.mum.cs.projects.carpooling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.transaction.annotation.Propagation;

import edu.mum.cs.projects.carpooling.domain.entity.User;

@Controller
@Transactional(propagation = Propagation.SUPPORTS)

public class WelcomeController {
	

	@RequestMapping("/welcome")
	public String dashboard(Model model, HttpSession session) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		session.setAttribute("username", user.getLastName());
		session.setAttribute("email", user.getEmailAddress());
		session.setAttribute("vehicle", user.getVicheles());
		System.err.println(user.getVicheles().size());
  
		return "welcome";
	}
}
