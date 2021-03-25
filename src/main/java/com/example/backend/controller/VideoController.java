package com.example.backend.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entity.Student;

@RestController
@RequestMapping("/video")
public class VideoController {
	
	public VideoController() {
		System.out.println("VideoController");
	}
	
	private static final String template = "Hell, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/video")
	public Student greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Student(counter.incrementAndGet(), String.format(template, name));
	}
	
}

