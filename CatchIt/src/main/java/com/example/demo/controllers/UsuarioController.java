package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Usuario;
import com.example.demo.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	/*
	 * como deve ser a chamasda dess função post =
	 * http://localhost:8080/usuarios?nome=Joao
	 * 
	 * 
	 * 
	 * 
	 */

	@PostMapping
	public Usuario criarUsuario(@RequestParam String nome) {
		return usuarioService.criarUsuario(nome);
	}

	@GetMapping
	public List<Usuario> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}

	@GetMapping("/{id}")
	public Usuario getUsuarioById(Long id) {
		return usuarioService.getUsuarioById(id);
	}

	@PatchMapping("/{id}/pontuacao")
	public ResponseEntity<Usuario> atualizarPontuacao(
	        @PathVariable Long id, 
	        @RequestBody Map<String, Integer> payload) {
	    
	    Integer pontuacao = payload.get("pontuacao");
	    Usuario usuario = usuarioService.atualizarPontuacao(id, pontuacao);
	    return ResponseEntity.ok(usuario);
	}
}