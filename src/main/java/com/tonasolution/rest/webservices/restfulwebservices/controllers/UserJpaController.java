package com.tonasolution.rest.webservices.restfulwebservices.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tonasolution.rest.webservices.restfulwebservices.business.UserService;
import com.tonasolution.rest.webservices.restfulwebservices.entity.Post;
import com.tonasolution.rest.webservices.restfulwebservices.entity.User;
import com.tonasolution.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;

@RestController
public class UserJpaController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/jpa/users")
	public List<User> retreiveAllUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retreiveUser(@PathVariable int id) {
		User user = userService.findOne(id);
		if(user==null)
			throw new UserNotFoundException(" id- " + id);
		
		Resource<User> resource = new Resource<User>(user);
		
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
				ControllerLinkBuilder
				.methodOn(this.getClass())
				.retreiveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteById(id);
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userService.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
								.buildAndExpand(savedUser.getId())
								.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getPosts(@PathVariable int id) {
		User user = userService.findOne(id);
		return user.getPostes();
	}
	
	
}
