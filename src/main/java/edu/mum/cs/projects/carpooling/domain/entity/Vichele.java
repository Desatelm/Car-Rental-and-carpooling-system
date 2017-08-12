package edu.mum.cs.projects.carpooling.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

public class Vichele {
	
	int id;
	String model;
	String type;
	String company;
	String engineType;
	String color;
	int numberOfSeats;
	
	List<Ride> ride= new ArrayList<>();
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	User user;
}
