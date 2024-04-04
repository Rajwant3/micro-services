package com.rest.webservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("db")
public class UserDBController {

	@Autowired
	private UserRepository userRepository;
	

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	@GetMapping("/users/{id}")
	public User getUserByID(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User Not Found: " + id);
		}
		return user.get();
	}

	@DeleteMapping("/users/{id}")
	public void deleteUserByID(@PathVariable Integer id) {
		userRepository.deleteById(id);

	}

}
