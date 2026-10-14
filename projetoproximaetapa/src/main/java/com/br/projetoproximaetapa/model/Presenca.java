package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Presenca")
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenca")
    private Integer idPresenca;

    @Column(name = "id_inscricao", nullable = false)
    private Integer idInscricao;

    @Column(name = "id_encontro", nullable = false)
    private Integer idEncontro;

    @Column(name = "cpf_professor", length = 11)
    private String cpfProfessor;

    @Column(name = "status_presenca", length = 20, nullable = false)
    private String statusPresenca = "presente";

    @Column(name = "data_presenca", nullable = false)
    private LocalDateTime dataPresenca = LocalDateTime.now();

    public Presenca() {}

    public Integer getIdPresenca() { 
        return idPresenca; 
    }
    public void setIdPresenca(Integer idPresenca) { 
        this.idPresenca = idPresenca; 
    }

    public Integer getIdInscricao() { 
        return idInscricao; 
    }
    public void setIdInscricao(Integer idInscricao) { 
        this.idInscricao = idInscricao; 
    }

    public Integer getIdEncontro() { 
        return idEncontro; 
    }
    public void setIdEncontro(Integer idEncontro) { 
        this.idEncontro = idEncontro; 
    }

    public String getCpfProfessor() { 
        return cpfProfessor; 
    }
    public void setCpfProfessor(String cpfProfessor) { 
        this.cpfProfessor = cpfProfessor; 
    }

    public String getStatusPresenca() { 
        return statusPresenca; 
    }
    public void setStatusPresenca(String statusPresenca) { 
        this.statusPresenca = statusPresenca; 
    }

    public LocalDateTime getDataPresenca() { 
        return dataPresenca; 
    }
    public void setDataPresenca(LocalDateTime dataPresenca) { 
        this.dataPresenca = dataPresenca; 
    }
}