package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data 

@Entity
@Table(name = "Administrador")
public class Administrador {

    @Id
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "cargo", length = 100, nullable = false)
    private String cargo;
}