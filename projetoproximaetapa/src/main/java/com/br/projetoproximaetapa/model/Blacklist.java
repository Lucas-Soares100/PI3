package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Blacklist")
public class Blacklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blacklist")
    private Integer idBlacklist;

    @Column(name = "cpf_aluno", length = 11, nullable = false)
    private String cpfAluno;

    @Column(name = "cpf_professor", length = 11, nullable = false)
    private String cpfProfessor;

    @Column(name = "motivo", columnDefinition = "TEXT", nullable = false)
    private String motivo;

    @Column(name = "dias_bloqueio", nullable = false)
    private Integer diasBloqueio;

    @Column(name = "data_inicio", nullable = false)
    private LocalDateTime dataInicio = LocalDateTime.now();

    @Column(name = "data_fim", insertable = false, updatable = false)
    private LocalDateTime dataFim;

    public Blacklist() {}

    public Integer getIdBlacklist() { 
        return idBlacklist; 
    }
    public void setIdBlacklist(Integer idBlacklist) { 
        this.idBlacklist = idBlacklist; 
    }

    public String getCpfAluno() { 
        return cpfAluno; 
    }
    public void setCpfAluno(String cpfAluno) { 
        this.cpfAluno = cpfAluno; 
    }

    public String getCpfProfessor() { 
        return cpfProfessor; 
    }
    public void setCpfProfessor(String cpfProfessor) { 
        this.cpfProfessor = cpfProfessor; 
    }

    public String getMotivo() { 
        return motivo; 
    }
    public void setMotivo(String motivo) { 
        this.motivo = motivo; 
    }

    public Integer getDiasBloqueio() { 
        return diasBloqueio; 
    }
    public void setDiasBloqueio(Integer diasBloqueio) { 
        this.diasBloqueio = diasBloqueio; 
    }

    public LocalDateTime getDataInicio() { 
        return dataInicio; 
    }
    public void setDataInicio(LocalDateTime dataInicio) { 
        this.dataInicio = dataInicio; 
    }

    public LocalDateTime getDataFim() { 
        return dataFim; 
    }
}