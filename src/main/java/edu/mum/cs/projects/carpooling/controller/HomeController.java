package edu.mum.cs.projects.carpooling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class HomeController {

	@RequestMapping("/")
	public String home() {
		return "home";
	}
}
