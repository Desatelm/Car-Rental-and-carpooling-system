package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ride")
public class Ride {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ride_id")
	int id;

	@NotNull(message="Required")
	@Column(name = "departure_place")
	String departure;

	@NotNull(message="Required")
	@Column(name = "destination_place")
	String destination;

	@Column(name = "pickup_place")
	String pickUp;

	@NotNull(message="Required")
	@DateTimeFormat(pattern="MM/dd/yyyy")
	@Column(name = "departure_date")
	@Temporal(TemporalType.DATE)
	Date departureDate;

	@NotNull(message="Required")
	@Column(name = "departure_time")
	String departureTime;

	@Column(name = "offered_by")
	String offeredBy;

	@NotNull(message="Required")
	//@Size(min=10,message="Price must be greater than $10")
	@Column(name = "price")
	double price;

	@NotNull(message="Required")
	@Column(name = "seat_no")
	int noSeat;
	
	@Transient
	int model;

	@Enumerated
	RideStatus status;

	@NotNull(message="Required")
	@Column(name = "waiting_time")
	String waitingTime;

	@ManyToOne(cascade = CascadeType.ALL)
	Vehicle vehicle;

	@OneToMany(mappedBy = "ride", cascade = CascadeType.PERSIST)
	List<FeedBack> feedbacks = new ArrayList<>();

	@ManyToMany(cascade = CascadeType.PERSIST)
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

	public void setFeedbacks(FeedBack feedbacks) {
		this.feedbacks.add(feedbacks);
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user.add(user);
	}
	
	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

}
