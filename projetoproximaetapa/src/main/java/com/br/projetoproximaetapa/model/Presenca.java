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
@Table(name = "Presenca")
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenca")
    private int id_presenca;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_atividade", nullable = false)
    private Atividade atividade;

    @Column(name = "status_presenca", length = 20)
    private String status_presenca;

    @Column(name = "data_presenca", nullable = false, updatable = false)
    private LocalDateTime data_presenca;

    public Presenca() {
        this.data_presenca = LocalDateTime.now();
    }

    public int getId_presenca() {
        return id_presenca;
    }

    public void setId_presenca(int id_presenca) {
        this.id_presenca = id_presenca;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public String getStatus_presenca() {
        return status_presenca;
    }

    public void setStatus_presenca(String status_presenca) {
        this.status_presenca = status_presenca;
    }

    public LocalDateTime getData_presenca() {
        return data_presenca;
    }

    public void setData_presenca(LocalDateTime data_presenca) {
        this.data_presenca = data_presenca;
    }
}