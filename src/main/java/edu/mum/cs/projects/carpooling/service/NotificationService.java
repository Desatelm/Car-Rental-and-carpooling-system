package edu.mum.cs.projects.carpooling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.carpooling.domain.entity.User;

@Service
public class NotificationService {
	@Autowired
	private JavaMailSender javaMailSender;

	public NotificationService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}

	public void sendNotification(User user) throws MailException {
		// send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("2dbcarpoolingsystem@gmail.com");
		mail.setSubject("Registration ");
		mail.setText("Thank you for joining to our CarPooling system");
		javaMailSender.send(mail);
	}

	public void sendNotificationNewMessage(User user, String msg) throws MailException {
		// send email
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(user.getEmailAddress());
		mail.setFrom("2dbcarpoolingsystem@gmail.com");
		mail.setSubject("Registration ");
		mail.setText(msg);
		javaMailSender.send(mail);
	}

}
