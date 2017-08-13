package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {
	
	@Id
	@GeneratedValue
	int id;
	
	String model;
	String type;
	String Make;	
	String color;
	int numberOfSeats;
	
	@OneToMany(mappedBy="vehicle")
	List<Ride> ride= new ArrayList<>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	User user;

	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(int id, String model, String type, String make, String color, int numberOfSeats, List<Ride> ride,
			User user) {
		super();
		this.id = id;
		this.model = model;
		this.type = type;
		Make = make;
		this.color = color;
		this.numberOfSeats = numberOfSeats;
		this.ride = ride;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


	public String getMake() {
		return Make;
	}

	public void setMake(String make) {
		Make = make;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public List<Ride> getRide() {
		return ride;
	}

	public void setRide(List<Ride> ride) {
		this.ride = ride;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
