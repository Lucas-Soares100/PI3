package com.br.projetoproximaetapa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDateTime;

@Entity
@Table(name = "Inscricao")
public class Inscricao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscricao")
    private int id_inscricao;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @Column(name = "status_inscricao", length = 20, nullable = false)
    private String status_inscricao = "enrolled";

    @Column(name = "data_inscricao", nullable = false, updatable = false)
    private LocalDateTime data_inscricao;

    public Inscricao() {
        this.data_inscricao = LocalDateTime.now();
    }

    public int getId_inscricao() {
        return id_inscricao;
    }

    public void setId_inscricao(int id_inscricao) {
        this.id_inscricao = id_inscricao;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public String getStatus_inscricao() {
        return status_inscricao;
    }

    public void setStatus_inscricao(String status_inscricao) {
        this.status_inscricao = status_inscricao;
    }

    public LocalDateTime getData_inscricao() {
        return data_inscricao;
    }

    public void setData_inscricao(LocalDateTime data_inscricao) {
        this.data_inscricao = data_inscricao;
    }
}