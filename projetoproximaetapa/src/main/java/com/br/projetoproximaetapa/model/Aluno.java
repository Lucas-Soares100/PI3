package com.br.projetoproximaetapa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "Aluno") 
public class Aluno {
	
	@Id		//Define o id como chave primária
	@GeneratedValue (strategy = GenerationType.IDENTITY)	//Faz com que seja Autoincremento
	@Column(name = "id_aluno")	//Define o nome da coluna que será ID
	private int id_aluno;

	@Column(name = "nome_aluno", length = 150, nullable = false)	//Define o nome da coluna que será Nome
	private String nome_aluno;
	
	@Column(name = "telefone_aluno", length = 20)	//Define o nome da coluna que será Telefone
	private String telefone_aluno;
	
	@Column(name = "escola", length = 150)	//Define o nome da coluna que será Escola
	private String escola;
	
	@Column(name = "cidade", length = 150)	//Define o nome da coluna que será Cidade
	private String cidade;
	
	@Column(name = "grade", length = 20)	//Define o nome da coluna que será Grade
	private String grade;
	
	@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
private String senha;


	public Aluno(){
	}
	
	
	public int getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(int id_aluno) {
		this.id_aluno = id_aluno;
	}
	public String getNome_aluno() {
		return nome_aluno;
	}
	public void setNome_aluno(String nome_aluno) {
		this.nome_aluno = nome_aluno;
	}
	public String getTelefone_aluno() {
		return telefone_aluno;
	}
	public void setTelefone_aluno(String telefone_aluno) {
		this.telefone_aluno = telefone_aluno;
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

	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
