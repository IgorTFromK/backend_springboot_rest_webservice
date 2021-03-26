package com.example.backend.repository;

import java.util.List;
import java.util.Optional;

import com.example.backend.entity.Video;

public interface IVideoService {
	
	public Video saveVideo(long id, Video video);
	
	public Optional<Video> findVideo(long id);
	
	public List<Video> findAllVideos(long id);
	
	public boolean deletedVideo(long id);

}
