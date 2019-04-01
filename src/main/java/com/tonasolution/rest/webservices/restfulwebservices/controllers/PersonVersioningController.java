package com.tonasolution.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonasolution.rest.webservices.restfulwebservices.entity.Name;
import com.tonasolution.rest.webservices.restfulwebservices.entity.PersonV1;
import com.tonasolution.rest.webservices.restfulwebservices.entity.PersonV2;

@RestController
public class PersonVersioningController {
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2("Bob charlie");
	}
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1(new Name("Bob", "Charlie"));
	}
}
