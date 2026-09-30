package com.br.projetoproximaetapa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "Atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade")
    private int id_atividade;

    @Column(name = "nome_atividade", length = 150, nullable = false)
    private String nome_atividade;

    @Column(name = "data_atividade")
    private Date data_atividade;

    public Atividade() {
    }

    public int getId_atividade() {
        return id_atividade;
    }

    public void setId_atividade(int id_atividade) {
        this.id_atividade = id_atividade;
    }

    public String getNome_atividade() {
        return nome_atividade;
    }

    public void setNome_atividade(String nome_atividade) {
        this.nome_atividade = nome_atividade;
    }

    public Date getData_atividade() {
        return data_atividade;
    }

    public void setData_atividade(Date data_atividade) {
        this.data_atividade = data_atividade;
    }
}