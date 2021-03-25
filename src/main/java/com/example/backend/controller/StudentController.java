package com.example.backend.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Student;
import com.example.backend.repository.IStudentRepository;

@RestController
public class StudentController {

	@Autowired
	IStudentRepository studentRepository;
	
	public StudentController() {
		System.out.println("UserController");
	}
	
	@GetMapping("/users")
	public List<Student> getAllUsers() {
		return studentRepository.findAllUser();
	}
	
	@PostMapping("/user")
	public Student addUser(@RequestBody Student user) {
		return studentRepository.saveUser(user);
	}
	
	
}