package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(name = "id_atividade", nullable = false)
    private Integer idAtividade;

    @Column(name = "id_universidade", nullable = false)
    private Integer idUniversidade;

    @Column(name = "cpf_professor", length = 11)
    private String cpfProfessor;

    @Column(name = "nome_curso", length = 150, nullable = false)
    private String nomeCurso;

    @Column(name = "descricao_curso", columnDefinition = "TEXT", nullable = false)
    private String descricaoCurso;

    @Column(name = "data_curso", nullable = false)
    private LocalDate dataCurso;

    @Column(name = "horario_curso", nullable = false)
    private LocalTime horarioCurso;

    @Column(name = "local_curso", length = 150, nullable = false)
    private String localCurso;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "quantidade_aula", nullable = false)
    private Integer quantidadeAula;

    public Curso() {
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Integer getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(Integer idAtividade) {
        this.idAtividade = idAtividade;
    }

    public Integer getIdUniversidade() {
        return idUniversidade;
    }

    public void setIdUniversidade(Integer idUniversidade) {
        this.idUniversidade = idUniversidade;
    }

    public String getCpfProfessor() {
        return cpfProfessor;
    }

    public void setCpfProfessor(String cpfProfessor) {
        this.cpfProfessor = cpfProfessor;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getDescricaoCurso() {
        return descricaoCurso;
    }

    public void setDescricaoCurso(String descricaoCurso) {
        this.descricaoCurso = descricaoCurso;
    }

    public LocalDate getDataCurso() {
        return dataCurso;
    }

    public void setDataCurso(LocalDate dataCurso) {
        this.dataCurso = dataCurso;
    }

    public LocalTime getHorarioCurso() {
        return horarioCurso;
    }

    public void setHorarioCurso(LocalTime horarioCurso) {
        this.horarioCurso = horarioCurso;
    }

    public String getLocalCurso() {
        return localCurso;
    }

    public void setLocalCurso(String localCurso) {
        this.localCurso = localCurso;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getQuantidadeAula() {
        return quantidadeAula;
    }

    public void setQuantidadeAula(Integer quantidadeAula) {
        this.quantidadeAula = quantidadeAula;
    }
}