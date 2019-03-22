package com.tonasolution.rest.webservices.restfulwebservices.entity;

import java.util.Date;

public class User {
	
	private Integer id;
	
	private String name;
	
	private Date birthDate;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", birthDate=" + birthDate + "]";
	}
	
}