package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Encontro")
public class Encontro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_encontro")
    private Integer idEncontro;

    @Column(name = "id_curso", nullable = false)
    private Integer idCurso;

    @Column(name = "numero_encontro", nullable = false)
    private Integer numeroEncontro;

    @Column(name = "data_encontro", nullable = false)
    private LocalDate dataEncontro;

    @Column(name = "codigo", length = 30, unique = true)
    private String codigo;

    public Encontro() {}

    public Integer getIdEncontro() { 
        return idEncontro; 
    }
    public void setIdEncontro(Integer idEncontro) { 
        this.idEncontro = idEncontro; 
    }
    public Integer getIdCurso() { 
        return idCurso; 

    }
    public void setIdCurso(Integer idCurso) { 
        this.idCurso = idCurso; 
    }
    public Integer getNumeroEncontro() { 
        return numeroEncontro; 
    }
    public void setNumeroEncontro(Integer numeroEncontro) { 
        this.numeroEncontro = numeroEncontro; 
    }
    public LocalDate getDataEncontro() { 
        return dataEncontro; 
    }
    public void setDataEncontro(LocalDate dataEncontro) { 
        this.dataEncontro = dataEncontro; 
    }
    public String getCodigo() { 
        return codigo; 

    }
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }
}