package edu.mum.cs.projects.carpooling.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;
import edu.mum.cs.projects.carpooling.domain.entity.User;

@Component
@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class Receiver {
	@Autowired
	UserService userService;

	@Autowired
	NotificationService notificationService;

	@JmsListener(destination = "mailbox", containerFactory = "myFactory")
	public void receiveMessage(MessageBox msg) {

		User user = userService.getUserByID(msg.getReceiverId());

		MessageBox mailbox = new MessageBox();

		mailbox.setSenderEmail(msg.getSenderEmail());
		mailbox.setMessage(msg.getMessage());

		List<MessageBox> messages = user.getMessageBox();
		messages.add(mailbox);
		user.setMessageBox(messages);
		userService.createUser(user);

		try {
			notificationService.sendNotificationNewMessage(user);
			;
		} catch (MailException e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Received <" + msg + ">");
	}

}
