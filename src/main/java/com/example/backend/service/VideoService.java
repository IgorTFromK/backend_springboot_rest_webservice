package com.example.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backend.entity.Video;
import com.example.backend.repository.IVideoRepository;
import com.example.backend.repository.VideoRepository;

@Service
public class VideoService implements IVideoRepository{

	@Autowired
	VideoRepository videoRepository;
	
	@Override
	public Video saveVideo(Video video) {
		return (Video) videoRepository.save(video);
	}

	@Override
	public Optional<Video> findVideo(int id) {
		return (Optional<Video>) videoRepository.findById(id);
	}

	@Override
	public List<Video> findAllUser() {
		return (List<Video>) videoRepository.findAll();
	}

}
