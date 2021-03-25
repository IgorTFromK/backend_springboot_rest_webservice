package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import com.example.backend.entity.Video;

public interface IVideoRepository {
	
public Video saveVideo(Video video);
	
	public Optional<Video> findVideo(int id);
	
	public List<Video> findAllUser();

}
