package edu.mum.cs.projects.carpooling.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.carpooling.domain.entity.FeedBack;
import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.User;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedBack, Integer> {

	public FeedBack findById(int id);
	
	List<FeedBack> findByUser(User user);
	
	List<FeedBack> findByRide(Ride ride);

}

