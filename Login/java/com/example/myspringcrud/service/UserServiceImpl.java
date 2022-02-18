package com.example.myspringcrud.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myspringcrud.model.User;
import com.example.myspringcrud.responsitory.UserResponsitory;

@Service
public class UserServiceImpl implements UserService {
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static Pattern pattern;
	private Matcher matcher;
	@Autowired
	UserResponsitory res;

	@Override
	public List<User> findAll() {
		return res.findAll();
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

	@Override
	public boolean checkEmail(String email) {
		 pattern = Pattern.compile(EMAIL_PATTERN);
		 matcher = pattern.matcher(email);
	     return matcher.matches();	
	}

	
	
 
}
