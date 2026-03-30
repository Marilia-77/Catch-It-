package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Alternativas;
import com.example.demo.services.AlternativasService;

@RestController
@RequestMapping("/alternativas")
public class AlternativasController {

    private AlternativasService alternativasService;

    public AlternativasController(AlternativasService alternativasService) {
        this.alternativasService = alternativasService;
    }

    @GetMapping("/{perguntaId}")
    public List<Alternativas> buscarAlternativas(@PathVariable Long perguntaId) {
        return alternativasService.buscarAlternativas(perguntaId);
    }
}