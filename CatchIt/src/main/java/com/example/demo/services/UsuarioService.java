package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Usuario;
import com.example.demo.repositories.RespostaUserRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	private UsuarioRepository usuarioRepository;
	private RespostaUserRepository respostaUserRepository;

	public UsuarioService(UsuarioRepository usuarioRepository, RespostaUserRepository respostaUserRepository) {
		this.usuarioRepository = usuarioRepository;
		this.respostaUserRepository = respostaUserRepository;
	}

	public Usuario criarUsuario(String nome) {

		Usuario usuario = new Usuario();

		usuario.setNome(nome);
		usuario.setPontuacao(0);

		return usuarioRepository.save(usuario);
	}

	public Usuario atualizarPontuacao(Long id, Integer novaPontuacao) {
	    Usuario usuario = usuarioRepository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
	    usuario.setPontuacao(novaPontuacao);
	    return usuarioRepository.save(usuario);
	}

	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
	}

	public void resetarJogo(Long usuarioId) {

		respostaUserRepository.deleteByUsuarioId(usuarioId);
		usuarioRepository.deleteById(usuarioId);

	}
}