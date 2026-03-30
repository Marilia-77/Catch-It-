package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Alternativas;
import com.example.demo.repositories.AlternativasRepository;

@Service
public class AlternativasService {

	private AlternativasRepository alternativasRepository;
	
	
	  public AlternativasService(AlternativasRepository alternativasRepository) {
	        this.alternativasRepository = alternativasRepository;
	    }

	
	   public List<Alternativas> buscarAlternativas(Long perguntaId){
	        return alternativasRepository.findByPerguntaId(perguntaId);
	    }
	}

