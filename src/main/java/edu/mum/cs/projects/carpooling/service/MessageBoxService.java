package edu.mum.cs.projects.carpooling.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;
import edu.mum.cs.projects.carpooling.repository.MessageBoxRepository;

public class MessageBoxService {
	@Autowired
	MessageBoxRepository messageBoxRepository;
	
	void creatMessageBox(MessageBox messageBox){
		messageBoxRepository.save(messageBox);
	}
	

}
