package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Administrador")
public class Administrador {

    @Id
    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "cargo", length = 100, nullable = false)
    private String cargo;

    public Administrador() {}

    public String getCpf() { 
        return cpf; 
    }
    public void setCpf(String cpf) { 
        this.cpf = cpf; 
    }
    public String getCargo() { 
        return cargo; 
    }
    public void setCargo(String cargo) { 
        this.cargo = cargo; 
    }
}