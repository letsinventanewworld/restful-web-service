package com.tonasolution.rest.webservices.restfulwebservices.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tonasolution.rest.webservices.restfulwebservices.dao.PostDao;
import com.tonasolution.rest.webservices.restfulwebservices.dao.UserDao;
import com.tonasolution.rest.webservices.restfulwebservices.entity.Post;
import com.tonasolution.rest.webservices.restfulwebservices.entity.User;
import com.tonasolution.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;

@Component
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	
	public List<Post> findAll(){
		return postDao.findAll();
	}
	
	public Post save(Post post) {
		postDao.save(post);
		return post;
	}
	
	public Post findOne(int id) throws Exception {
		Optional<Post> postOptional =  postDao.findById(id);
		
		if(!postOptional.isPresent())
			throw new Exception("Post id not found - " + id);
			
		return postOptional.get();
	}
	
	public void deleteById(int id) {
		postDao.findById(id);
	}
}
