package edu.mum.cs.projects.carpooling.service;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.carpooling.repository.RideRepository;
import edu.mum.cs.projects.carpooling.domain.entity.Ride;

@Service
public class RideService {
	
	@Autowired
	private RideRepository repository;
	
	public List<Ride> findByRide(String departure, String destination){
		
		return repository.findByDepartureLikeAndDestinationLike(departure, destination);
		
	}
	
	public List<Ride> findByRideF(String departure,String destination, Date date,int seat) {
		return repository.findByDepartureLikeAndDestinationLikeAndDepartureDateEqualsAndNoSeatGreaterThanEqual(departure, destination, date, seat);
	}
	
}
