package edu.mum.cs.projects.carpooling.domain.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
