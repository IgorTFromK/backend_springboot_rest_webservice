package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Student;
import com.example.backend.entity.Video;
import com.example.backend.repository.IStudentService;
import com.example.backend.repository.IVideoService;
import com.example.backend.repository.StudentRepository;

@Service
public class StudentService implements IStudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	IVideoService videoService;
	
	public Student saveStudent(Student student) {
		return (Student) studentRepository.save(student);
	}

	@Override
	public Optional<Student> findStudent(long id) {
		return  (Optional<Student>)  studentRepository.findById(id);
	}

	@Override
	public List<Student> findAllStudents() {
		
		return (List<Student>) studentRepository.findAll();
	}

	@Override
	public boolean deleteStudent(long id) {
		
		Optional<Student> student = (Optional<Student>) studentRepository.findById(id);
		if(student.isEmpty()) {
			return false;
		}
		for(Video video: student.get().getVideos()) {
			videoService.deletedVideo(video.getId());
		}
		studentRepository.deleteById(id);
		return true;
	}
	
	
}
