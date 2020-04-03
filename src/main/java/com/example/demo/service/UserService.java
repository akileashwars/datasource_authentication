package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	public List<User> getUsers()
	{
	List<User> findAll = repository.findAll();	
	return findAll;	
	}
	
	public User addUser(User user)
	{
		
		User user1 = repository.save(user);
		return user1;
	}
}
