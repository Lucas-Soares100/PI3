package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Vaga")
public class Vaga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vaga")
    private Integer idVaga;

    @Column(name = "cpf_admin", length = 11, nullable = false)
    private String cpfAdmin;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "empresa", length = 150, nullable = false)
    private String empresa;

    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "link_externo", length = 255)
    private String linkExterno;

    @Column(name = "data_publicacao", nullable = false)
    private LocalDateTime dataPublicacao = LocalDateTime.now();

    public Vaga() {}

    public Integer getIdVaga() { 
        return idVaga; 
    }
    public void setIdVaga(Integer idVaga) { 
        this.idVaga = idVaga; 
    }

    public String getCpfAdmin() { 
        return cpfAdmin; 
    }
    public void setCpfAdmin(String cpfAdmin) { 
        this.cpfAdmin = cpfAdmin; 
    }

    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    public String getEmpresa() { 
        return empresa; 
    }
    public void setEmpresa(String empresa) { 
        this.empresa = empresa; 
    }

    public String getDescricao() { 
        return descricao; 
    }
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    }

    public String getLinkExterno() { 
        return linkExterno; 
    }
    public void setLinkExterno(String linkExterno) { 
        this.linkExterno = linkExterno; 
    }

    public LocalDateTime getDataPublicacao() { 
        return dataPublicacao; 
    }
    public void setDataPublicacao(LocalDateTime dataPublicacao) { 
        this.dataPublicacao = dataPublicacao; 
    }
}