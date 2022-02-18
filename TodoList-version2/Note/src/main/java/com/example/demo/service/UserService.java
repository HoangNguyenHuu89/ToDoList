package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	Iterable<User> findAll();

	List<User> search(String name);

	User findOne(long id);
	
	void save(User n);

	void delete(User id);
	
    boolean checkLogin(String username, String password);
}
