package com.rest.webservices.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import jakarta.validation.Valid;

@RestController
public class UserController {

	@Autowired
	private UserDaoService userDaoService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}
	
//	HateOAS
	@GetMapping("/users/hateoas/{id}")
	public EntityModel<User> getUserWithHateOas(@PathVariable Integer id) {
		User user = userDaoService.findById(id);
		if (user == null) {
			throw new UserNotFoundException("User Not Found: " + id);
		}
		EntityModel<User> entityModel= EntityModel.of(user);
		WebMvcLinkBuilder webMvcLinkBuilder=linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(webMvcLinkBuilder.withRel("Rk-Users"));
		return entityModel;
	}

	@GetMapping("/users/{id}")
	public User getUserByID(@PathVariable Integer id) {
		User user = userDaoService.findById(id);
		if (user == null) {
			throw new UserNotFoundException("User Not Found: " + id);
		}
		return user;
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserByID(@PathVariable Integer id) {
		userDaoService.deleteById(id);

	}

	@PostMapping("/users/")
	public ResponseEntity<User> createUsers(@Valid @RequestBody User user) {
		int id = userDaoService.createUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/user/inter")
	public String getI18nMessage() {

		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
	}

}
