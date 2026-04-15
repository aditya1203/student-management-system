package com.example.studentmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String course;
	
	public Student() {
		
	}
	
	public Student(Long id, String name,String email, String course) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.course=course;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setEmain(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setCourse(String course) {
		this.course=course;
	}
	
	public String getCourse() {
		return course;
	}
	
}
