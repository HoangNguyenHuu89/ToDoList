package com.example.myspring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myspring.model.User;
import com.example.myspring.service.UserService;
import com.example.myspring.web.dto.UserRegistrationDto;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping
	public String showRegistrationForm() {
		return "registration";
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
		List<User> userList = userService.findAll();
		for (User user : userList) {
			if(user.getEmail().equals(registrationDto.getEmail())) {
				return "redirect:/registration?error";
			}
		}
		userService.save(registrationDto);
		return "redirect:/registration?success";
	}
}
