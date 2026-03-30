package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "resposta_user")
public class RespostaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "alternativa_id")
    private Alternativas alternativa;

    public RespostaUser() {}

    public RespostaUser(Usuario usuario, Alternativas alternativa) {
        this.usuario = usuario;
        this.alternativa= alternativa;
    }

    // getters e setters

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Alternativas getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativas alternativa) {
        this.alternativa = alternativa;
    }
}