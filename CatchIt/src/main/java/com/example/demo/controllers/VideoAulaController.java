package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.VideoAula;
import com.example.demo.services.VideoAulaService;

@RestController
@RequestMapping("/videos")
public class VideoAulaController {

    private VideoAulaService videoAulaService;

    public VideoAulaController(VideoAulaService videoAulaService) {
        this.videoAulaService = videoAulaService;
    }

    @GetMapping
    public List<VideoAula> listarVideos() {
        return videoAulaService.listarVideos();
    }

    @PostMapping
    public VideoAula salvar(@RequestBody VideoAula video) {
        return videoAulaService.salvar(video);
    }
}