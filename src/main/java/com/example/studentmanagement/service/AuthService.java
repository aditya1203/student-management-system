package com.example.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.RegisterRequest;
import com.example.studentmanagement.entity.User;
import com.example.studentmanagement.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String register(RegisterRequest request) {
		
		if(userRepository.existsByEmail(request.getEmail())) {
			return "Email Already Exists";
		}
		
		User user=new User();
		
		user.setUsername(request.getName());
		user.setEmail(request.getEmail());
		
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		
		user.setRole("User");
		
		userRepository.save(user);
		
		return "User Registered Successfully";
	}
	
}
