package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade")
    private Integer idAtividade;

    @Column(name = "nome_atividade", length = 150, nullable = false)
    private String nomeAtividade;

    @Column(name = "data_atividade")
    private LocalDate dataAtividade;

    public Atividade() {}

    public Integer getIdAtividade() { 
        return idAtividade; 
    }
    public void setIdAtividade(Integer idAtividade) { 
        this.idAtividade = idAtividade; 
    }
    public String getNomeAtividade() { 
        return nomeAtividade; 
    }
    public void setNomeAtividade(String nomeAtividade) { 
        this.nomeAtividade = nomeAtividade; 
    }
    public LocalDate getDataAtividade() { 
        return dataAtividade; 
    }
    public void setDataAtividade(LocalDate dataAtividade) { 
        this.dataAtividade = dataAtividade; 
    }
}