package com.br.projetoproximaetapa.model;

import lombok.Data;

@Data 

public class LoginRequest {
    private String nome_aluno;
    private String senha;
}