package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.UserPrincipal;
import com.example.demo.service.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService userService;

	@RequestMapping("/addUser")
	User addUser() {
		BCryptPasswordEncoder passwordencoder = new BCryptPasswordEncoder();
		String encode = passwordencoder.encode("welcome");
		User user = new User("Akil", encode, "ADMIN", "");
		userService.addUser(user);
		return user;
	}

	@RequestMapping("/getUsers")
	List<User> getUsers() {
		List<User> users = userService.getUsers();
		return users;
	}

	@RequestMapping("/getLoggedInUser")
	String getLoggedInUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserPrincipal principal=(UserPrincipal) authentication.getPrincipal();
		return principal.getUsername();
	}

}
