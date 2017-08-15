package edu.mum.cs.projects.carpooling.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.RideStatus;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer> {

	Ride findById(int id);

	Ride findByDeparture(String departure);

	Ride findByStatus(RideStatus status);

	Ride findByDestination(String destination);

	Ride findByDepartureDate(Date date);

	public List<Ride> findByDepartureLikeAndDestinationLike(String departure, String destination);

	public List<Ride> findByDepartureLikeAndDestinationLikeAndDepartureDateEqualsAndNoSeatGreaterThanEqual(
			String departure, String destination, Date date, int seat);

	public List<Ride> findByUserId(int id);
	public List<Ride> findByUser_emailAddress(String name);
	@Query("from Ride r where r.user is not empty and r.offeredBy=:email")
	public List<Ride> getBookedRides(@Param("email") String email);
}