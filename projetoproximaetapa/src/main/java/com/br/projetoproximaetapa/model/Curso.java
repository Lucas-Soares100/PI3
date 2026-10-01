package com.br.projetoproximaetapa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int id_curso;

    @ManyToOne
    @JoinColumn(name = "id_atividade", nullable = false)
    private Atividade atividade;

    @ManyToOne
    @JoinColumn(name = "id_universidade", nullable = false)
    private Universidade universidade;

    @Column(name = "nome_curso", length = 150, nullable = false)
    private String nome_curso;

    @Column(name = "descricao_curso", columnDefinition = "TEXT")
    private String descricao_curso;

    @Column(name = "data_curso")
    private Date data_curso;

    @Column(name = "horario_curso")
    private Time horario_curso;

    @Column(name = "local_curso", length = 150)
    private String local_curso;

    @Column(name = "carga_horaria")
    private Integer carga_horaria;

    @Column(name = "quantidade_aula")
    private Integer quantidade_aula;

    public Curso() {
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Universidade getUniversidade() {
        return universidade;
    }

    public void setUniversidade(Universidade universidade) {
        this.universidade = universidade;
    }

    public String getNome_curso() {
        return nome_curso;
    }

    public void setNome_curso(String nome_curso) {
        this.nome_curso = nome_curso;
    }

    public String getDescricao_curso() {
        return descricao_curso;
    }

    public void setDescricao_curso(String descricao_curso) {
        this.descricao_curso = descricao_curso;
    }

    public Date getData_curso() {
        return data_curso;
    }

    public void setData_curso(Date data_curso) {
        this.data_curso = data_curso;
    }

    public Time getHorario_curso() {
        return horario_curso;
    }

    public void setHorario_curso(Time horario_curso) {
        this.horario_curso = horario_curso;
    }

    public String getLocal_curso() {
        return local_curso;
    }

    public void setLocal_curso(String local_curso) {
        this.local_curso = local_curso;
    }

    public Integer getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(Integer carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Integer getQuantidade_aula() {
        return quantidade_aula;
    }

    public void setQuantidade_aula(Integer quantidade_aula) {
        this.quantidade_aula = quantidade_aula;
    }
}