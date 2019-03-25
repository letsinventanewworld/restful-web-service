package com.tonasolution.rest.webservices.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tonasolution.rest.webservices.restfulwebservices.dao.UserDaoService;
import com.tonasolution.rest.webservices.restfulwebservices.entity.User;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping("/users")
	public List<User> retreiveAllUsers(){
		return userDaoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retreiveUser(@PathVariable int id) {
		return userDaoService.findOne(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {
		User savedUser = userDaoService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
								.buildAndExpand(savedUser.getId())
								.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
}
