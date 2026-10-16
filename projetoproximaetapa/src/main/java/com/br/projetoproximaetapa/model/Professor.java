package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data 

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
}