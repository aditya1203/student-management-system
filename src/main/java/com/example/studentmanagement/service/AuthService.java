package com.example.studentmanagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.dto.LoginRequest;
import com.example.studentmanagement.dto.RegisterRequest;
import com.example.studentmanagement.entity.User;
import com.example.studentmanagement.repository.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
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
	
	public String login(LoginRequest request) {
		Optional<User> optionalUser=userRepository.findByEmail(request.getEmail());
		
		if(optionalUser.isEmpty()) {
			return "Invalid Email or Password";
		}
		
		User user=optionalUser.get();
		
		boolean isMatch=passwordEncoder.matches(
				request.getPassword(), 
				user.getPassword());
		if(!isMatch) {
			return "Invalid Email or Password";
			}
		
		return jwtService.generateToken(user.getEmail());
	}
	
	
}
