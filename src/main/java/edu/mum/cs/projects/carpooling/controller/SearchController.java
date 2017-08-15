package edu.mum.cs.projects.carpooling.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.service.RideService;

@Controller
public class SearchController {
	@Autowired
	private RideService rideservice;

	@GetMapping("/search")
	public String search() {
		return "search";
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String getData(String departure, String destination, Model model) {
		List<Ride> rides = rideservice.findByRide(departure, destination);
		model.addAttribute("rides", rides);
		model.addAttribute("departure", departure);
		model.addAttribute("destination", destination);
		return "search";
	}

	@RequestMapping(path = "/searchF", method = RequestMethod.POST)
	public String getSearchData(String departure, String destination, String date, int seat, Model model) {
		DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date startDate;
		try {
			startDate = (Date) formatter.parse(date);
		} catch (ParseException e) {
			return "redirect:/search";
		}

		List<Ride> rides = rideservice.findByRideF(departure, destination, startDate, seat);
		model.addAttribute("rides", rides);
		model.addAttribute("departure", departure);
		model.addAttribute("date", date);
		model.addAttribute("seat", seat);
		model.addAttribute("destination", destination);
		return "search";
	}

	@RequestMapping(path = "/searchF", method = RequestMethod.GET)
	public String getSearchDataG() {
		return "redirect:/search";
	}
}
