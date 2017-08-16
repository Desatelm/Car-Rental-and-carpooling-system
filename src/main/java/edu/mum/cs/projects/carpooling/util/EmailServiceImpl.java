package edu.mum.cs.projects.carpooling.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService{

	@Autowired
	JavaMailSender emailSender;
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		SimpleMailMessage simpleMailMsg = new SimpleMailMessage();
		simpleMailMsg.setTo(to);
		simpleMailMsg.setSubject(subject);
		simpleMailMsg.setText(body);
		emailSender.send(simpleMailMsg);
		
	}
	
	
}
