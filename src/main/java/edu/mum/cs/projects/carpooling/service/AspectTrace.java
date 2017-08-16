package edu.mum.cs.projects.carpooling.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;
import edu.mum.cs.projects.carpooling.domain.entity.User;


@Aspect
@Component
public class AspectTrace {
	
	@Autowired
	NotificationService notificationService;	
	@Autowired
	UserService userService;
	
	@After(" execution(* edu.mum.cs.projects.carpooling.service.Receiver.receiveMessage(..)) && args(msg)")
	public void traceMethod(JoinPoint jointPoint, MessageBox msg){
		User user = userService.getUserByID(msg.getReceiverId());

		try {
			notificationService.sendNotificationNewMessage(user);
			
		} catch (MailException e) {
			System.err.println(e.getMessage());
		}
		 System.out.println("Message has been sent from  Email Address" + msg.getSenderEmail() );
		
	}

}
