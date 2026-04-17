package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	//injects repository automatically
	@Autowired
	private StudentService studentService; 
	
	//Add new Student
	@PostMapping
	public Student addStudent(@Valid @RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	//Fetch all student
	@GetMapping
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@GetMapping("/{id}")
	public Student getStudentByID(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deletestudent(id);
		return "Student Deleted Successfully";
	}
	
	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
		
		return studentService.updateStudent(id, student);
	}
	
	
}
