package com.rest.webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	static {
		users.add(new User(1, "Rajwant", LocalDate.now().minusYears(26)));
		users.add(new User(2, "Jaanu", LocalDate.now().minusYears(27)));
		users.add(new User(3, "Lovepreet", LocalDate.now().minusYears(34)));
		users.add(new User(4, "Pinky", LocalDate.now().minusYears(24)));

	}
	private static int usersCount = users.size();

	public List<User> findAll() {
		return users;
	}

	public User findById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().get();
	}

	public Integer createUser(User user) {
		user.setId(++usersCount);
		users.add(user);
		return user.getId();
	}

	public void deleteById(Integer id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

}
