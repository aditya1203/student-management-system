package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.studentmanagement.dto.StudentRequestDTO;
import com.example.studentmanagement.dto.StudentResponseDTO;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;

//Marks Business layer
@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

//	public Student saveStudent(Student student) {
//		
//		if(studentRepository.existsByEmail(student.getEmail())) {
//			throw new ResponseStatusException(
//					HttpStatus.BAD_REQUEST,
//					"Email Already Exists"
//					);
//		}
//		
//		return studentRepository.save(student);
//	}
	
	public StudentResponseDTO saveStudent(StudentRequestDTO dto) {
		
		if(studentRepository.existsByEmail(dto.getEmail())) {
			throw new ResponseStatusException(
					HttpStatus.BAD_REQUEST,
					"Email Aleradt Exists"
					);
		}
		
		Student student=new Student();
		student.setName(dto.getName());
		student.setEmail(dto.getEmail());
		student.setCourse(dto.getCourse());
		
		Student saveStudent=studentRepository.save(student);
		
		return new StudentResponseDTO(saveStudent.getId(), saveStudent.getName(), saveStudent.getEmail(), saveStudent.getCourse());
	}
	
	
	public List<StudentResponseDTO> getAllStudent(){
		List<Student> students=studentRepository.findAll();
		
		return students.stream().map(student->new StudentResponseDTO(
				student.getId(),
				student.getName(),
				student.getEmail(),
				student.getCourse())).toList();
	}
	
//	public Student getStudentById(Long id) {
//		return studentRepository.findById(id)
//				.orElseThrow(()-> new ResponseStatusException(
//						HttpStatus.NOT_FOUND,
//						"Student with id "+ id +" not found"
//						));
//	}
	
	public StudentResponseDTO getStudentById(Long id) {
		Student student=studentRepository.findById(id)
				.orElseThrow(()->new ResponseStatusException(
						HttpStatus.NOT_FOUND,
						"Student Not found"
						));
		return new StudentResponseDTO(
				student.getId(),
				student.getName(),
				student.getEmail(),
				student.getCourse()
				);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public String deletestudent(Long id) {
		Student student= studentRepository.findById(id)
				.orElseThrow(()->
				new ResponseStatusException(
					HttpStatus.NOT_FOUND,"Student Not found"));
		studentRepository.delete(student);
//		studentRepository.deleteById(id);
		return "Student Deleted Successfully";
	}
	
//	public Student updateStudent(Long id,Student student) {
//		Student existing = studentRepository.findById(id).orElse(null);
//		
//		if(existing!=null) {
//			existing.setName(student.getName());
//			existing.setEmail(student.getEmail());
//			existing.setCourse(student.getCourse());
//			
//			return studentRepository.save(existing);
//		}
//		
//		return null;
//	}
	public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {

	    Student student = studentRepository.findById(id)
	            .orElseThrow(() -> new ResponseStatusException(
	                    HttpStatus.NOT_FOUND,
	                    "Student Not Found"
	            ));

	    student.setName(dto.getName());
	    student.setEmail(dto.getEmail());
	    student.setCourse(dto.getCourse());

	    Student updatedStudent = studentRepository.save(student);

	    return new StudentResponseDTO(
	            updatedStudent.getId(),
	            updatedStudent.getName(),
	            updatedStudent.getEmail(),
	            updatedStudent.getCourse()
	    );
	}
}
