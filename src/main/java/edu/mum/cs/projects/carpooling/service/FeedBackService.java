package edu.mum.cs.projects.carpooling.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.carpooling.domain.entity.FeedBack;
import edu.mum.cs.projects.carpooling.domain.entity.Ride;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.domain.entity.Vehicle;
import edu.mum.cs.projects.carpooling.repository.FeedBackRepository;

@Service
@Transactional
public class FeedBackService {
	@Autowired
	private FeedBackRepository feedBackRepository;

	public void createFeedBacks(FeedBack feedBack) {
		feedBackRepository.save(feedBack);
	}

	public FeedBack getFeedbackById(int id) {
		return feedBackRepository.findById(id);
	}

	public void removeFeedBack(FeedBack feedback) {
		feedBackRepository.delete(feedback.getId());
	}

	public List<FeedBack> getFeedbackByUser(User user) {

		return feedBackRepository.findByUser(user);
	}

	/*public List<FeedBack> getFeedbackByRide(Ride ride) {
		return feedBackRepository.findByRide(ride);
	}*/

}
