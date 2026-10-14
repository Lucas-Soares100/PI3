package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Aluno")
public class Aluno {

    @Id
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "telefone_aluno", length = 20, nullable = false)
    private String telefoneAluno;

    @Column(name = "escola", length = 150, nullable = false)
    private String escola;

    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;

    @Column(name = "grade", length = 20, nullable = false)
    private String grade;


	public Aluno(){
	}
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone_aluno() {
		return telefoneAluno;
	}
	public void setTelefone_aluno(String telefoneAluno) {
		this.telefoneAluno = telefoneAluno;
	}
	public String getEscola() {
		return escola;
	}
	public void setEscola(String escola) {
		this.escola = escola;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
