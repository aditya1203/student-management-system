package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

//Marks Business layer
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	public Student saveStudent(Student student) {
		
		if(studentRepository.existsByEmail(student.getEmail())) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"Email Already Exists"
					);
		}
		
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(()-> new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Student with id "+ id +" not found"
						));
	}
	
	public void deletestudent(Long id) {
		studentRepository.deleteById(id);
	}
	
	public Student updateStudent(Long id,Student student) {
		Student existing = studentRepository.findById(id).orElse(null);
		
		if(existing!=null) {
			existing.setName(student.getName());
			existing.setEmail(student.getEmail());
			existing.setCourse(student.getCourse());
			
			return studentRepository.save(existing);
		}
		
		return null;
	}
	
}
