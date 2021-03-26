package com.example.backend.restcontroller;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Student;
import com.example.backend.repository.IStudentService;

@RestController
public class StudentRestController {

	@Autowired
	IStudentService studentService;
	
	public StudentRestController() {
		System.out.println("UserController");
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentService.findAllStudents();
	}
	
	@GetMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable long id) {
		return studentService.findStudent(id);
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping("/student/{id}")
	public boolean deleteStudent(@PathVariable long id) {
		return studentService.deleteStudent(id);
	}
	
	
}