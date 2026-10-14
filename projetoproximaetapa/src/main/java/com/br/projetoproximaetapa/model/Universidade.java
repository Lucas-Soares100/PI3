package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Universidade")
public class Universidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_universidade")
    private Integer idUniversidade;

    @Column(name = "nome_universidade", length = 150, nullable = false)
    private String nomeUniversidade;

    @Column(name = "local_universidade", length = 150)
    private String localUniversidade;

    public Universidade() {
    }

    public Integer getIdUniversidade() {
        return idUniversidade; 
    }
    public void setIdUniversidade(Integer idUniversidade) { 
        this.idUniversidade = idUniversidade;
    }
    public String getNomeUniversidade() { 
        return nomeUniversidade; 
    }
    public void setNomeUniversidade(String nomeUniversidade) { 
        this.nomeUniversidade = nomeUniversidade; 
    }
    public String getLocalUniversidade() { 
        return localUniversidade; 
    }
    public void setLocalUniversidade(String localUniversidade) { 
        this.localUniversidade = localUniversidade; 
    }
}