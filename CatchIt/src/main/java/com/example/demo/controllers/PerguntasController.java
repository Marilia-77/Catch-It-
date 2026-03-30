package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Perguntas;
import com.example.demo.services.PerguntasService;

@RestController
@RequestMapping("/perguntas")
public class PerguntasController {

    private PerguntasService perguntasService;

    public PerguntasController(PerguntasService perguntasService) {
        this.perguntasService = perguntasService;
    }

    @GetMapping
    public List<Perguntas> listarPerguntas() {
        return perguntasService.listarPerguntas();
    }

    @GetMapping("/5")
    public List<Perguntas> pegar5Perguntas() {
        return perguntasService.pegar5Perguntas();
    }
}