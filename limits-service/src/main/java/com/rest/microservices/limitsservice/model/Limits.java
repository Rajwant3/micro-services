package com.rest.microservices.limitsservice.model;

import lombok.Data;

@Data
public class Limits {
	
	private int minimum;
	private int maximum;

	public Limits(int minimum, int maximum) {
		super();
		this.minimum = minimum;
		this.maximum = maximum;
	}

}
