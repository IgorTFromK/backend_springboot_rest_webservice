package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import com.example.backend.entity.Student;

public interface IStudentService {
	
	public Student saveStudent(Student student);
	
	public Optional<Student> findStudent(long id);
	
	public List<Student> findAllStudents();
	
	public boolean deleteStudent(long id);

}
