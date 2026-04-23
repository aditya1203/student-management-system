package com.example.studentmanagement.service;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public class JwtService {
	
	private final String SECERET_KEY="mysecretkeymysecretkeymysecretkeymysecretkeymysecretkeymysecretkey12345";
	
	public String generateToken(String email) {
		return Jwts.builder()
				.setSubject(email)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+ 1000 *60 *60))
				.signWith(SignatureAlgorithm.HS256,SECERET_KEY)
				.compact();
	}
	
}
