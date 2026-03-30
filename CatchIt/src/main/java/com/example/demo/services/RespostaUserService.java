package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Alternativas;
import com.example.demo.entities.RespostaUser;
import com.example.demo.entities.Usuario;
import com.example.demo.repositories.AlternativasRepository;
import com.example.demo.repositories.RespostaUserRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class RespostaUserService {

    @Autowired
    private RespostaUserRepository respostaUserRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AlternativasRepository alternativasRepository;

    public boolean responderPergunta(Long usuarioId, Long alternativaId){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow();

        Alternativas alternativa = alternativasRepository.findById(alternativaId)
                .orElseThrow();

        RespostaUser resposta = new RespostaUser(usuario, alternativa);

        respostaUserRepository.save(resposta);

        if(alternativa.isCorreta()){

            usuario.setPontuacao(usuario.getPontuacao() + 1);

            usuarioRepository.save(usuario);

            return true;
        }

        return false;
    }
    
}