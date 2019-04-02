package com.tonasolution.rest.webservices.restfulwebservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tonasolution.rest.webservices.restfulwebservices.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
