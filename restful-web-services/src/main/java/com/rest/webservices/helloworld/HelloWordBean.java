package com.rest.webservices.helloworld;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.Data;

@Data
@JsonFilter("HomeBeanFilter")
public class HelloWordBean {

	private String message;
	
	private String field1;
	
	private String field2;

	public HelloWordBean(String message, String field1, String field2) {
		super();
		this.message = message;
		this.field1 = field1;
		this.field2 = field2;
	}
	

	

	
}
