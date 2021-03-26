package com.example.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	@Query("SELECT u FROM Student u WHERE u.deleted = FALSE") 
	public List<Student> findAll();
}
