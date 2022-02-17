package com.example.myspringcrud.service;

import java.util.List;

import com.example.myspringcrud.model.User;

public interface UserService {
	List<User> findAll();

	List<User> search(String name);

	User findOne(long id);
	
	void save(User n);

	void delete(User id);
	
    boolean checkLogin(String username, String password);
    boolean checkEmail(String email);
  
    	 
    	
}
