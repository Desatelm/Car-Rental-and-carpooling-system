package edu.mum.cs.projects.carpooling.domain.entity;

import javax.persistence.*;

@Embeddable
public class Rating {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rating_id")
	int id;
	@Column(name = "value")
	int value;
	@Column(name = "counter")
	int counter;
}
