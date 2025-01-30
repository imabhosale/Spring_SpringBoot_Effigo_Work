package com.abhi.restful_web_services.Users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	// static List

	private static List<Users> users = new ArrayList<>();
	private static int userCount=0;
	static {
		users.add(new Users(++userCount, "abhishek", LocalDate.now().minusYears(14)));
		users.add(new Users(++userCount, "kunal", LocalDate.now().minusYears(13)));

		users.add(new Users(++userCount, "aniket", LocalDate.now().minusYears(19)));

	}

	public List<Users> findAll() {
		return users;
	}

	public Users findById(int id) {
		Predicate<? super Users> predicate = user -> user.getId().equals(id);
		Users user = users.stream().filter(predicate).findFirst().orElse(null);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super Users> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}
	
	public Users saveUser(Users user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}

}
