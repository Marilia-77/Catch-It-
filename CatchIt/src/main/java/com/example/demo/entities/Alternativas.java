package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "Alternativas")
public class Alternativas{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String opcao;

    private boolean correta;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")  
    private Perguntas pergunta;

    public Alternativas() {}

    public Alternativas(String opcao, boolean correta, Perguntas pergunta) {
        this.opcao = opcao;
        this.correta = correta;
        this.pergunta = pergunta;
    }

    public Long getId() {
        return id;
    }

    public String getOpcao() {
        return opcao;
    }

    public void setOpcao(String opcao) {
        this.opcao = opcao;
    }

    public boolean isCorreta() {
        return correta;
    }

    public void setCorreta(boolean correta) {
        this.correta = correta;
    }

    public Perguntas getPergunta() {
        return pergunta;
    }

    public void setPergunta(Perguntas pergunta) {
        this.pergunta = pergunta;
    }
}