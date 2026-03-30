package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.VideoAula;
import com.example.demo.repositories.VideoAulaRepository;

@Service 
public class VideoAulaService {

	    @Autowired
	    private VideoAulaRepository videoAulaRepository;

		
		  public VideoAulaService(VideoAulaRepository videoAulaRepository) {
		        this.videoAulaRepository = videoAulaRepository;
		    }
	    public List<VideoAula> listarVideos(){
	        return videoAulaRepository.findAll();
	    }

	    public VideoAula salvar(VideoAula video){
	        return videoAulaRepository.save(video);
	    }

	}

