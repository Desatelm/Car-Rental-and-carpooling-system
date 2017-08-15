package edu.mum.cs.projects.carpooling.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.carpooling.domain.entity.FeedBack;
import edu.mum.cs.projects.carpooling.repository.FeedBackRepository;

@Service
@Transactional
public class FeedBackService {
	@Autowired
	private FeedBackRepository feedBackRepository;

	public void createFeedBacks(FeedBack feedBack) {
		feedBackRepository.save(feedBack);
	}
}
