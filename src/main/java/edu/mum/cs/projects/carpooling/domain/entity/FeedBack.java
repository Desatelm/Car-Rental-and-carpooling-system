package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.Date;

import javax.persistence.*;

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
