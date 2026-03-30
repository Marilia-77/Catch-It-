package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Alternativas;

public interface AlternativasRepository extends JpaRepository<Alternativas, Long>{
	List<Alternativas> findByPerguntaId(Long perguntaId);
}
