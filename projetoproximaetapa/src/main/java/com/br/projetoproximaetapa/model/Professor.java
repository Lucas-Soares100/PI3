package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Professor")
public class Professor {

    @Id
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "telefone_professor", length = 20, nullable = false)
    private String telefoneProfessor;

    @Column(name = "especialidade", length = 150, nullable = false)
    private String especialidade;

    public Professor() {}

    public String getCpf() { 
        return cpf; }
    public void setCpf(String cpf) { 
        this.cpf = cpf; }
    public String getTelefoneProfessor() { 
        return telefoneProfessor; }
    public void setTelefoneProfessor(String telefoneProfessor) { 
        this.telefoneProfessor = telefoneProfessor; }
    public String getEspecialidade() { 
        return especialidade; }
    public void setEspecialidade(String especialidade) { 
        this.especialidade = especialidade; }
}