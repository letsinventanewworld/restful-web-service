package com.tonasolution.rest.webservices.restfulwebservices.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonasolution.rest.webservices.restfulwebservices.entity.Name;
import com.tonasolution.rest.webservices.restfulwebservices.entity.PersonV1;
import com.tonasolution.rest.webservices.restfulwebservices.entity.PersonV2;

@RestController
public class PersonVersioningController {
	
	@GetMapping(value="/person", params="version=2")
	public PersonV2 personV2() {
		return new PersonV2("Bob charlie");
	}
	@GetMapping(value="/person", params="version=1")
	public PersonV1 personV1() {
		return new PersonV1(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 personXAPIVERSIONV2() {
		return new PersonV2("Bob charlie");
	}
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 personXAPIVERSIONV1() {
		return new PersonV1(new Name("Bob", "Charlie"));
	}
	
	@GetMapping(value="/person/produces", produces="application/tonasolution.company.app-v2+json")
	public PersonV2 personproducesv2() {
		return new PersonV2("Bob charlie");
	}
	@GetMapping(value="/person/produces", produces="application/tonasolution.company.app-v1+json")
	public PersonV1 personproducesv1() {
		return new PersonV1(new Name("Bob", "Charlie"));
	}
}
