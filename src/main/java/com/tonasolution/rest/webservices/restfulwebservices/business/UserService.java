package com.tonasolution.rest.webservices.restfulwebservices.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tonasolution.rest.webservices.restfulwebservices.dao.UserDao;
import com.tonasolution.rest.webservices.restfulwebservices.entity.User;
import com.tonasolution.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;

@Component
public class UserService {
	
//	private static List<User> users = new ArrayList<>();
//	
//	private static int counter = 3;
//	static {
//		users.add(new User(1, "Adam", new Date()));
//		users.add(new User(2, "Eve", new Date()));
//		users.add(new User(3, "Ali", new Date()));
//	}
//	
	@Autowired
	private UserDao userDao;
	
	
	public List<User> findAll(){
		return userDao.findAll();
	}
	
	public User save(User user) {
		userDao.save(user);
		return user;
	}
	
	public User findOne(int id) {
		Optional<User> userOptional =  userDao.findById(id);
		
		if(!userOptional.isPresent())
			throw new UserNotFoundException("id - " + id);
			
		return userOptional.get();
	}
	
	public User deleteById(int id) {
//		Iterator<User> iterator = users.iterator();
//		
//		while(iterator.hasNext()) {
//			User user = iterator.next();
//			if(user.getId() == id) {
//				iterator.remove();
//				return user;
//			} 
//		}
//		
//		return null;
		Optional<User> user = userDao.findById(id);
		userDao.deleteById(user.get().getId());
		return user.get();
	}
}
