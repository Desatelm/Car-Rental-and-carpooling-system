package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ride")
public class Ride {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ride_id")
	int id;

	@Column(name = "departure_place")
	String departure;

	@Column(name = "destination_place")
	String destination;

	@Column(name = "pickup_place")
	String pickUp;

	@Column(name = "departure_date")
	@Temporal(TemporalType.DATE)
	Date departureDate;

	@Column(name = "departure_time")
	String departureTime;

	@Column(name = "offered_by")
	String offeredBy;

	@Column(name = "price")
	double price;

	@Column(name = "seat_no")
	int noSeat;

	@Enumerated
	RideStatus status;

	@Column(name = "waiting_time")
	String waitingTime;

	@ManyToOne(cascade = CascadeType.ALL)
	Vehicle vehicle;

	@OneToMany(mappedBy = "ride")
	List<FeedBack> feedbacks = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "user_ride", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ride_id"))
	List<User> user = new ArrayList<>();

	public Ride() {

	}

	public Ride(Ride ride) {
		ride.departure = ride.getDeparture();
		ride.destination = ride.getDestination();
		ride.departureDate = ride.getDepartureDate();
		ride.departureTime = ride.getDepartureTime();
		ride.noSeat = ride.getNoSeat();
		ride.status = ride.getStatus();
		ride.price = ride.getPrice();
		ride.waitingTime = ride.getWaitingTime();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getPickUp() {
		return pickUp;
	}

	public void setPickUp(String pickUp) {
		this.pickUp = pickUp;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNoSeat() {
		return noSeat;
	}

	public void setNoSeat(int noSeat) {
		this.noSeat = noSeat;
	}

	public RideStatus getStatus() {
		return status;
	}

	public void setStatus(RideStatus status) {
		this.status = status;
	}

	public String getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(String waitingTime) {
		this.waitingTime = waitingTime;
	}

	public String getOfferedBy() {
		return offeredBy;
	}

	public void setOfferedBy(String offeredBy) {
		this.offeredBy = offeredBy;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<FeedBack> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedBack> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user.add(user);
	}

}
