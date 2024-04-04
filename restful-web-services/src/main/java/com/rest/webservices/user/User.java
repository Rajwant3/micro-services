package com.rest.webservices.user;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name="user_details")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	@Past(message = "Birth Date should be in past")
	private LocalDate birthDate;


	@Size(min = 2, message = "Name should have at least 2 characters")
	private String name;
	
	protected User() {
		
	}
	public User(Integer id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

}
