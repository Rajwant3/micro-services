package com.rest.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.microservices.limitsservice.configurations.Configurations;
import com.rest.microservices.limitsservice.model.Limits;

@RestController
public class LimitsController {

	@Autowired
	private Configurations configurations;

	@GetMapping("/limits")
	public Limits retrieveLimits() {
		return new Limits(configurations.getMinimum(), configurations.getMaximum());
	}

}
