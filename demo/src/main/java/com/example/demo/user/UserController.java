package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

// API layer
@RestController	
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		// not loosly coupled
		//userService = new UserService();
		
		// using dependency injection
		this.userService = userService;
	}
	
	public UserClass getUserById(int id) {
		return userService.getUserById(id);
	}
	
	public UserClass getUserByName(String name) {
		return userService.getUserByName(name);
	}

	public List<UserClass> getUsers() {
		return userService.getUsers();
	}
	
	public void addUser(UserClass user) {
		userService.addUser(user);
	}
	
	public UserClass getUserByUserName(String username) {
		return userService.getUserByUserName(username);
	}
	

}
