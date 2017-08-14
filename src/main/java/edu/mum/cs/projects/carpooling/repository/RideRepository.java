package edu.mum.cs.projects.carpooling.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Integer>{
	
	public List<Ride> findByDepartureLikeAndDestinationLike(String departure, String destination);
	public List<Ride> findByDepartureLikeAndDestinationLikeAndDepartureDateEqualsAndNoSeatGreaterThanEqual(String departure, String destination, Date date,int seat);

}
