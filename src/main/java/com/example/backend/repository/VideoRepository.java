package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Student;
import com.example.backend.entity.Video;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long>{
	
	@Query("SELECT u FROM Video u WHERE u.deleted = FALSE") 
	public List<Video> findAll();
	
	@Query("SELECT u FROM Video u WHERE u.deleted = FALSE AND u.id = :id")
	public Optional<Video> findById(@Param("id") Long Id);
	
	@Modifying
	@Query("UPDATE Video SET deleted=TRUE WHERE id = :id")
	public void deleteById(@Param("id") Long id);

}
