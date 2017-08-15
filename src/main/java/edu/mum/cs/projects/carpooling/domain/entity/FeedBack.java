package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "feedback")
public class FeedBack {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "feedback_id")
	int id;

	@Column(name = "comment_date")
	@Temporal(TemporalType.DATE)
	Date date;
	@Column(name = "comment_time")
	String time;
	@Column(name = "comment_message")
	String comment;
	@OneToOne
	User user;

	@JsonBackReference
	@ManyToOne(cascade = CascadeType.PERSIST)
	Ride ride;
	
	public FeedBack(){
		
	}

	public FeedBack(FeedBack feedBack) {
		this.id = feedBack.getId();
		this.comment = feedBack.comment;
		this.date = feedBack.getDate();
		this.time = feedBack.getTime();
		this.user = feedBack.getUser();
		this.ride = feedBack.getRide();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Ride getRide() {
		return ride;
	}

	public void setRide(Ride ride) {
		this.ride = ride;
	}

}
