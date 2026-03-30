package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "Perguntas")
public class Perguntas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String enunciado;

    public Perguntas() {
    }


    public Perguntas(String enunciado) {
        this.enunciado = enunciado;
    }

    public long getId() {
        return id;
    }

public void setId(long id) { this.id = id; }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }
}