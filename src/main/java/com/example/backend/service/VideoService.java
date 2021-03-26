package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Student;
import com.example.backend.entity.Video;
import com.example.backend.repository.IVideoService;
import com.example.backend.repository.StudentRepository;
import com.example.backend.repository.VideoRepository;

@Service
public class VideoService implements IVideoService{

	@Autowired
	VideoRepository videoRepository;
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Video saveVideo(long id, Video video) {
		Student student = ((Optional<Student>) studentRepository.findById(id)).get();
		if(student == null) {
			return null;
		}
		video.setStudent(student);
		Video saved_video = videoRepository.save(video);
		student.addVideo(saved_video);
		studentRepository.save(student);
		return saved_video;
	}

	@Override
	public Optional<Video> findVideo(long id) {
		return (Optional<Video>) videoRepository.findById(id);
	}

	@Override
	public List<Video> findAllVideos(long id) {
		
		Student student = ((Optional<Student>) studentRepository.findById(id)).get();
		if(student != null) {
			Video video = 	student.getVideos().get(0);
			if( video != null) {
				System.out.println(video.getTitle());
			}
		}
		
		return (List<Video>) videoRepository.findAll();
		
	}

	@Override
	public boolean deletedVideo(long id) {
		Video video = ((Optional<Video>) videoRepository.findById(id)).get();
		if(video == null ) {
			return false;
		}
		video.setDeleted(true);
		videoRepository.save(video);
		return true;
	}

}
