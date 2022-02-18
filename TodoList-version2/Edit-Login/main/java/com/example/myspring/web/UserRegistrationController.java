package com.example.myspring.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myspring.model.User;
import com.example.myspring.service.UserService;

@Controller
public class UserRegistrationController {

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/registration")
	public String registerUserAccount(@Validated User user, @RequestParam("password") String password,
			@RequestParam("password1") String password1) {
		List<User> userList = userService.findAll();
		for (User u : userList) {
			if (u.getEmail().equals(user.getEmail())) {
				return "redirect:/registration?error";
			} else if (userService.checkEmail(user.getEmail()) == false) {
				return "redirect:/registration?errorMail";
			} else if (!password.equals(password1)) {
				return "redirect:/registration?errorPass";
			}
		}
		userService.save(user);
		return "redirect:/registration?success";
	}
}
