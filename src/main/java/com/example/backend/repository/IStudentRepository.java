package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import com.example.backend.entity.Student;

public interface IStudentRepository {
	
	public Student saveUser(Student user);
	
	public Optional<Student> findUser(int id);
	
	public List<Student> findAllUser();

}
