package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("/user")
	public String login() {
		return "login";
	}

	@PostMapping(value = "/login")
	public String signin(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) {
		if (userService.checkLogin(username, password)) {
			return "home";
		}
		model.addAttribute("error", "Wrong user or password");
		return "login";

	}

	@GetMapping("/signup")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/check")
	public String save(@Validated User user, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "signup";
		}
		userService.save(user);
		redirect.addFlashAttribute("success", "Saved note successfully!");
		return "home";
	}
}
