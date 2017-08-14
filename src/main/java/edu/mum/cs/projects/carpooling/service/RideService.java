package edu.mum.cs.projects.carpooling.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.RideStatus;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.repository.RideRepository;

@Service
@Transactional
public class RideService {

	@Autowired
	private RideRepository rideRepository;

	public void createRide(Ride ride) {
		rideRepository.save(ride);
	}

	public Ride getRideByDeparture(String departure) {
		return rideRepository.findByDeparture(departure);
	}

	public Ride getRideByDestination(String destination) {
		return rideRepository.findByDestination(destination);
	}

	public Ride getRideByDepartureDate(String departureDate) {
		return rideRepository.findByDeparture(departureDate);
	}

	public Ride getRideByStatus(RideStatus status) {
		return rideRepository.findByStatus(status);
	}
	
	public List<Ride> getAllRides(){
		return rideRepository.findAll();
	}
}
