package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data 

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
}
