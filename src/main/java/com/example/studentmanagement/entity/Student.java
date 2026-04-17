package com.example.studentmanagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Name is required")
	private String name;
	@Column(unique=true)
	@Email(message="Email Valid Email")
	@NotBlank(message="Email is required")
	private String email;
	@NotBlank(message = "Course is required")
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
	
	public void setEmail(String email) {
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
