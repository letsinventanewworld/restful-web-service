package com.tonasolution.rest.webservices.restfulwebservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tonasolution.rest.webservices.restfulwebservices.entity.User;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int counter = 3;
	static {
		users.add(new User(1, "Adam", new Date()));
		users.add(new User(2, "Eve", new Date()));
		users.add(new User(3, "Ali", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null) user.setId(++counter);
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		
		for(User user : users) {
			if(user.getId() == id) return user;
		}
		
		return null;
	}
}
