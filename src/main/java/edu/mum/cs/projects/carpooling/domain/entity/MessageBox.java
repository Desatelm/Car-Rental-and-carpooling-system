package edu.mum.cs.projects.carpooling.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "Message_box")
public class MessageBox {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feedback_id")
	int messageId;
	String senderEmail;
	String message;
	@OneToOne
	@JoinColumn(name="user_id")
	User user;

}
