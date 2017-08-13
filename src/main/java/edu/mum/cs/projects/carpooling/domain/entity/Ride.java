package edu.mum.cs.projects.carpooling.domain.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



@Entity
@Table(name="ride")
public class Ride {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ride_id")
	int id;
	
	@Column(name= "departure_place")
	String departure;
	
	@Column(name= "destination_place")
	String destination;
	
	@Column(name= "pickup_place")
	String pickUp;
	
	@Column(name="departure_date")
	@Temporal(TemporalType.DATE)
	Date departureDate;
	
	
	/*@Temporal(TemporalType.TIME)
	@Column(name="departure_time")
	Time departureTime;
	*/
	@ElementCollection
	List<Double> price= new ArrayList<>();
	
	@Column(name="seat_no")
	int noSeat;
	
	@Enumerated
	RideStatus status;
	
	/*@Temporal(TemporalType.TIME)
	@Column(name="waiting_time")
	Time waitingTime;*/
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	Vehicle vehicle;
	
	@OneToMany(mappedBy="ride")
	List<FeedBack> feedbacks = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(name = "user_ride", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "ride_id"))
	List<User> user = new ArrayList<>();

	public Ride() {
	
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

	/*public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}*/

	public List<Double> getPrice() {
		return price;
	}

	public void setPrice(List<Double> price) {
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

	/*public Time getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(Time waitingTime) {
		this.waitingTime = waitingTime;
	}*/

	public Vehicle getVichele() {
		return vehicle;
	}

	public void setVichele(Vehicle vehicle) {
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

	public void setUser(List<User> user) {
		this.user = user;
	}

}
