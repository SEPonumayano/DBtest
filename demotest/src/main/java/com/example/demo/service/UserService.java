package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional(rollbackOn=Exception.class)
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> searchAll(){
		return userRepository.findAll();
	}

}