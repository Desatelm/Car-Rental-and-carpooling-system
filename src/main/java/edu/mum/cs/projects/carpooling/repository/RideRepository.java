package edu.mum.cs.projects.carpooling.repository;

import java.util.Date;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.RideStatus;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

	Optional<Ride> findById(int id);

	Ride findByDeparture(String departure);

	Ride findByStatus(RideStatus status);

	Ride findByDestination(String destination);

	Ride findByDepartureDate(Date date);

	public List<Ride> findByDepartureLikeAndDestinationLike(String departure, String destination);

	public List<Ride> findByDepartureLikeAndDestinationLikeAndDepartureDateEqualsAndNoSeatGreaterThanEqual(
			String departure, String destination, Date date, int seat);

}