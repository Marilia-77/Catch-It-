package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.RespostaUserService;

@RestController
@RequestMapping("/respostasUser")
public class RespostaUserController {

    private RespostaUserService respostaUserService;

    public RespostaUserController(RespostaUserService respostaUserService) {
        this.respostaUserService = respostaUserService;
    }

    @PostMapping
    public String responderPergunta(
            @RequestParam Long usuarioId,
            @RequestParam Long alternativaId) {

        boolean acertou = respostaUserService.responderPergunta(usuarioId, alternativaId);

        if (acertou) {
            return "Resposta correta!";
        } else {
            return "Resposta errada!";
        }
    }
}
