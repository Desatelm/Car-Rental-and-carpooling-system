package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue
	int id;
	
	@NotNull(message = "Required")
	String model;
	
	@NotNull(message = "Required")
	String type;
	
	@NotNull(message = "Required")
	String make;
	
	@NotNull(message = "Required")
	String color;
	int numberOfSeats;

	@JsonBackReference
	@OneToMany(mappedBy = "vehicle")
	List<Ride> ride = new ArrayList<>();

	@ManyToOne(cascade = CascadeType.PERSIST)
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
		this.make = make;
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
		return make;
	}

	public void setMake(String make) {
		this.make = make;
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
