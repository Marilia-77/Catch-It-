package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Perguntas;
import com.example.demo.repositories.PerguntasRepository;

@Service
public class PerguntasService {

    private PerguntasRepository perguntasRepository;

    public PerguntasService(PerguntasRepository perguntasRepository) {
        this.perguntasRepository = perguntasRepository;
    }

    public List<Perguntas> listarPerguntas(){
        return perguntasRepository.findAll();
    }

    public List<Perguntas> pegar5Perguntas(){

        List<Perguntas> perguntas = perguntasRepository.findAll();

        return perguntas.stream()
                .limit(5)
                .toList();
    }
}