package edu.mum.cs.projects.carpooling.domain.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Rating {

	@Column(name = "value")
	int value;
	@Column(name = "counter")
	int counter;
}
