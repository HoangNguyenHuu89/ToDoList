package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.responsitory.UserResponsitory;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserResponsitory res;

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findOne(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User n) {
		res.save(n);
		
	}

	@Override
	public void delete(User id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkLogin(String username, String password) {
		User user = res.findByNameContaining(username);
		if(user != null && user.getName().equals(username) && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
 
}
