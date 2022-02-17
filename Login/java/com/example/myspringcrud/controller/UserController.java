package com.example.myspringcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.myspringcrud.model.User;
import com.example.myspringcrud.service.UserService;

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
		if (username.equals("") || password.equals("")) {
			model.addAttribute("errorSyntax", "Không được để trống tài khoản và mật khẩu");
			return "login";
		} else {
			if (userService.checkLogin(username, password)) {
				model.addAttribute("username", "Welcome " + username);
				return "home";
			}
			model.addAttribute("error", "Tài khoản hoặc mật khẩu không chính xác");
			return "login";
		}

	}

	@GetMapping("/signup")
	public String add(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/save")
	public String save(@Validated User user, BindingResult result, Model model,
			@RequestParam("password") String password, @RequestParam("password1") String password1,
			@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("phone") String phone) {
		List<User> userList = userService.findAll();
		if (result.hasErrors() || !password.equals(password1)) {
			model.addAttribute("error", "Mật khẩu không khớp");
			return "signup";
		} else {
			for (User u : userList) {
				if (u.getName().equals(user.getName())) {
					model.addAttribute("error", "Tài khoản đã được đăng ký");
					return "signup";
				} else if (userService.checkEmail(email) == false) {
					model.addAttribute("error2", "Lỗi định dạng mail");
					return "signup";
				} else if (phone.length() != 10) {
					model.addAttribute("error3", "Số điện thoại chỉ có 10 số");
					return "signup";
				}
			}
			userService.save(user);
			return "login";
		}
	}
}
