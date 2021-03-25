package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
