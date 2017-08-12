package edu.mum.cs.projects.carpooling.domain.entity;

import javax.persistence.*;

@Embeddable
public class Rating {
	
	@Column(name = "value")
	int value;
	@Column(name = "counter")
	int counter;
}
