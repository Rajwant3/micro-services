package com.rest.microservices.limitsservice.configurations;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
@ConfigurationProperties("limits-service")
public class Configurations {
	private int minimum;
	private int maximum;
}
