package com.br.projetoproximaetapa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Universidade")
public class Universidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_universidade")
    private int id_universidade;

    @Column(name = "nome_universidade", length = 150, nullable = false)
    private String nome_universidade;

    @Column(name = "local_universidade", length = 150)
    private String local_universidade;

    public Universidade() {
    }

    public int getId_universidade() {
        return id_universidade;
    }

    public void setId_universidade(int id_universidade) {
        this.id_universidade = id_universidade;
    }

    public String getNome_universidade() {
        return nome_universidade;
    }

    public void setNome_universidade(String nome_universidade) {
        this.nome_universidade = nome_universidade;
    }

    public String getLocal_universidade() {
        return local_universidade;
    }

    public void setLocal_universidade(String local_universidade) {
        this.local_universidade = local_universidade;
    }
}