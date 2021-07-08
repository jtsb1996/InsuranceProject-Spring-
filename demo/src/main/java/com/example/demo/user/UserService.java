package com.example.demo.user;

import java.util.List;

import org.springframework.stereotype.Service;

// Service Layer
@Service
public class UserService{
	
	private final UserRepo userRepo;
	public UserService(UserRepo userRepo) {
		this.userRepo = userRepo;
	}
	
	public UserClass getUserById(int id) {
		return userRepo.getById(id);
	}
	
	public UserClass getUserByName(String name) {
		return userRepo.getByName(name);
	}
	
	public List<UserClass>getUsers() {
		return userRepo.findAll();
	}
	
	public void addUser(UserClass user) {
		userRepo.save(user);
	}
	
	public UserClass getUserByUserName(String username) {
		return userRepo.getByUserName(username);
	}

}
