package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

	@Query("SELECT u FROM Student u WHERE u.deleted = FALSE") 
	public List<Student> findAll();
	
	@Query("SELECT u FROM Student u WHERE u.deleted = FALSE AND u.id = :id")
	public Optional<Student> findById(@Param("id") Long Id);
	
	//UPDATE tabellenname SET variablenname='neuer Inhalt' WHERE id=3
	@Modifying
	@Query("UPDATE  Student SET deleted=TRUE WHERE id = :id")
	public void deleteById(@Param("id") Long id);
}
