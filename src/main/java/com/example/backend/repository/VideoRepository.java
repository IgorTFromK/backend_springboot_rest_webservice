package com.example.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.Video;

@Repository
public interface VideoRepository extends CrudRepository<Video, Long>{

}
