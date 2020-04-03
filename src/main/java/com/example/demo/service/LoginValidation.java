package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class LoginValidation implements UserDetailsService {

	final private UserRepository userRepository;

	@Autowired
	public LoginValidation(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User findByUserName = userRepository.findByUserName(username);
		System.out.println(findByUserName.getUserName()+"123");
		UserPrincipal userPrincipal = new com.example.demo.service.UserPrincipal(
				findByUserName);
		return userPrincipal;
	}
}
