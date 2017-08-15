package edu.mum.cs.projects.carpooling.controller;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.mum.cs.projects.carpooling.domain.entity.MessageBox;
import edu.mum.cs.projects.carpooling.domain.entity.User;
import edu.mum.cs.projects.carpooling.service.NotificationService;
import edu.mum.cs.projects.carpooling.service.UserService;

@Controller
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class MessageController {
	@Autowired
	UserService userService;

	@Autowired
	NotificationService notificationService;

	@Bean
	public JmsListenerContainerFactory<?> myFactory(ConnectionFactory connectionFactory,
			DefaultJmsListenerContainerFactoryConfigurer configurer) {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		// This provides all boot's default to this factory, including the
		// message converter
		configurer.configure(factory, connectionFactory);
		// You could still override some of Boot's default if necessary.
		return factory;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}

	@GetMapping(value = "/getMessageForm/{recieverId}")
	public String addmessage(Model model, @PathVariable Integer recieverId) {
		model.addAttribute("recieverId", recieverId);
		return "messageForm";
	}

	@Autowired
	JmsTemplate jmsTemplate;

	@PostMapping(value = "/addMessage")
	public String createMessage(@RequestParam String email, @RequestParam Integer recieverId,
			@RequestParam String message) {

		// Send a message with a POJO - the template reuse the message converter
		System.out.println("Sending an email message.");
		jmsTemplate.convertAndSend("mailbox", new MessageBox(email, recieverId, message));

		return "redirect:/welcome";
	}

	@GetMapping(value = "/getMessages")
	public String getMessages(Model model, @RequestParam String email) {
		System.err.println("##################" + email);
		User user = userService.getUserByemail(email);
		System.err.println("##################" + user.getMessageBox().size());
		model.addAttribute("messages", user.getMessageBox());
		System.err.println("##################" + user.getMessageBox().size());
		return "mailbox";
	}

}
