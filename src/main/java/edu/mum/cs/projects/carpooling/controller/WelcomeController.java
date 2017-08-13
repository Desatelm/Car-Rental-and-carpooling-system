package edu.mum.cs.projects.carpooling.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.projects.carpooling.domain.entity.User;

@Controller
// @Transactional(propagation = Propagation.REQUIRES_NEW)
public class WelcomeController {
	

	@RequestMapping("/welcome")
	public String dashboard(Model model, HttpSession session) {

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				
		session.setAttribute("email", user.getId());
		session.setAttribute("username", user.getLastName());

		return "welcome";
	}
}
