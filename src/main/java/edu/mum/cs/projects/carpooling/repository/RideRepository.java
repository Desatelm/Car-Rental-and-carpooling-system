package edu.mum.cs.projects.carpooling.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.RideStatus;
import edu.mum.cs.projects.carpooling.domain.entity.User;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

	Optional<Ride> findById(int id);

	Ride findByDeparture(String departure);

	Ride findByStatus(RideStatus status);

	Ride findByDestination(String destination);

	Ride findByDepartureDate(Date date);
	
}
