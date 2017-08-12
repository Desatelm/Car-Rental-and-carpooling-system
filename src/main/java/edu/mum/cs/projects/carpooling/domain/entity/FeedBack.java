package edu.mum.cs.projects.carpooling.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.*;

@Entity
@Table(name = "feedback")
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feedback_id")
	int id;
	@Column(name = "comment_date")
	LocalDate date;
	@Column(name = "comment_time")
	LocalTime time;
	@Column(name = "comment_message")
	String comment;
	@OneToOne()
	User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	Ride ride;
}
