package com.example.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Video;
import com.example.backend.repository.IVideoService;

@RestController
@RequestMapping("/student/{student_id}")
public class VideoController {
	
	@Autowired
	IVideoService videoService;
	
	public VideoController() {
		System.out.println("VideoController");
	}
	
	
	@GetMapping("/videos")
	public List<Video> getAllVideos(@PathVariable long student_id) {
		return videoService.findAllVideos(student_id);
	}
	
	@PostMapping("/video")
	public Video saveVideo(@PathVariable long student_id, @RequestBody Video video) {
		return videoService.saveVideo(student_id, video);
	}
	
}

