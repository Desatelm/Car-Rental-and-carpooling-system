package edu.mum.cs.projects.carpooling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.FeedBack;
import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.service.FeedBackService;
import edu.mum.cs.projects.carpooling.service.RideService;
import edu.mum.cs.projects.carpooling.service.UserService;

@Controller
@RequestMapping("feedback")
public class FeedBackController {

	@Autowired
	RideService rideService;
	@Autowired
	UserService userService;

	@Autowired
	FeedBackService feedBackService;

	@PostMapping(value = "/comment")
	public String showFeedback(FeedBack feed, Model model, @RequestParam String email, @RequestParam Integer id) {
		/*FeedBack feed = new FeedBack();
		feed = feedBack;*/
		// feedBack.setDate(new Date());
		User user = userService.getUserByemail(email);
		Ride ride = rideService.getRideById(id);
		feed.setRide(ride);
		feed.setUser(user);
		feedBackService.createFeedBacks(feed);
		return "redirect:/welcome";
	}
	
	@PostMapping(value = "/comment/delete/{id}")
	public String deleteFeedback(@PathVariable Integer id) {

		FeedBack feedback = feedBackService.getFeedbackById(id);
		Ride ride=rideService.getRideById(feedback.getRide().getId());
		ride.getFeedbacks().remove(feedback);
		feedBackService.removeFeedBack(feedback);

		return "redirect:/welcome";
	}
}
