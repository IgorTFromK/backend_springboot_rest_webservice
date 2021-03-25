package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Student;
import com.example.backend.repository.IStudentRepository;
import com.example.backend.repository.StudentRepository;

@Service
public class StudentService implements IStudentRepository {

	@Autowired
	StudentRepository studentRepository;
	
	public Student saveUser(Student user) {
		return (Student) studentRepository.save(user);
	}

	@Override
	public Optional<Student> findUser(int id) {
		return  (Optional<Student>)  studentRepository.findById(id);
	}

	@Override
	public List<Student> findAllUser() {
		return (List<Student>) studentRepository.findAll();
	}
}
