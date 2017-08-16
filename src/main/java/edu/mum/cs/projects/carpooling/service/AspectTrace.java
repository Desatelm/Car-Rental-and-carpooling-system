package edu.mum.cs.projects.carpooling.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;


import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.util.EmailService;


@Aspect
@Component
public class AspectTrace {
	
	@Autowired
	NotificationService notificationService;	
	@Autowired
	UserService userService;
	
	@Autowired
	EmailService emailService;
	
	@After(" execution(* edu.mum.cs.projects.carpooling.service.Receiver.receiveMessage(..)) && args(msg)")
	public void traceMethod(JoinPoint jointPoint, MessageBox msg){
		User user = userService.getUserByID(msg.getReceiverId());

		try {
			notificationService.sendNotificationNewMessage(user,"You got an new message at 2dbcarPooling system");
			
		} catch (MailException e) {
			System.err.println(e.getMessage());
		}
		 System.out.println("Message has been sent from  Email Address" + msg.getSenderEmail() );
		
	}
	
	@After("execution(* edu.mum.cs.projects.carpooling.service.RideService.cancelRide(..))&& args(userId,rideId)")
	public void traceMethodForsendingEmail(int userId, int rideId) {
		//MessageBox msg;
		//User user = userService.getUserByID(msg.getReceiverId());
		emailService.sendEmail(userService.getUserByID(userId).getEmailAddress(), "Message", "Welcome");
	}

}
