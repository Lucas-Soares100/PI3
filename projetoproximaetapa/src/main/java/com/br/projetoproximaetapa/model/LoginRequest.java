package com.br.projetoproximaetapa.model;

public class LoginRequest {
    private String nome_aluno;
    private String senha;
    
    public String getNome_aluno() {
        return nome_aluno;
    }
    public void setNome_aluno(String nome_aluno) {
        this.nome_aluno = nome_aluno;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

}