package com.example.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Video {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	@JsonIgnore
	private boolean deleted = false;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="student_id")
	private Student student;
	
	
	public Video() {}

	public Video(long id, String title) {
		this.id = id;
		this.title = title;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}


	
}
