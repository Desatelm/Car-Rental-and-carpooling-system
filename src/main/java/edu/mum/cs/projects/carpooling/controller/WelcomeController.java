package edu.mum.cs.projects.carpooling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.carpooling.domain.entity.Users;

@Controller
// @Transactional(propagation = Propagation.REQUIRES_NEW)
public class WelcomeController {
	

	@RequestMapping("/welcome")
	public String dashboard(Model model, HttpSession session) {

		Users user = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String has_Role = user.getRoles().getRole();
		String lastName = "";
		
		
		session.setAttribute("lastName", lastName);
		session.setAttribute("username", user.getName());

		return "welcome";
	}
}
