package com.example.myspring.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.myspring.model.User;
import com.example.myspring.web.dto.UserRegistrationDto;



public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
	List<User> findAll();
}
