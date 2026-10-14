package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notificacao")
    private Integer idNotificacao;

    @Column(name = "cpf_usuario", length = 11, nullable = false)
    private String cpfUsuario;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "mensagem", columnDefinition = "TEXT", nullable = false)
    private String mensagem;

    @Column(name = "tipo", length = 30, nullable = false)
    private String tipo = "sistema";

    @Column(name = "lida", nullable = false)
    private Boolean lida = false;

    @Column(name = "data_criacao", nullable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    public Notificacao() {}

    public Integer getIdNotificacao() { 
        return idNotificacao; 
    }
    public void setIdNotificacao(Integer idNotificacao) { 
        this.idNotificacao = idNotificacao; 
    }

    public String getCpfUsuario() { 
        return cpfUsuario; 
    }
    public void setCpfUsuario(String cpfUsuario) { 
        this.cpfUsuario = cpfUsuario; 
    }

    public String getTitulo() { 
        return titulo; 
    }
    public void setTitulo(String titulo) { 
        this.titulo = titulo; 
    }

    public String getMensagem() { 
        return mensagem; 
    }
    public void setMensagem(String mensagem) { 
        this.mensagem = mensagem; 
    }

    public String getTipo() { 
        return tipo; 
    }
    public void setTipo(String tipo) { 
        this.tipo = tipo; 
    }

    public Boolean getLida() { 
        return lida; 
    }
    public void setLida(Boolean lida) { 
        this.lida = lida; 
    }

    public LocalDateTime getDataCriacao() { 
        return dataCriacao; 
    }
    public void setDataCriacao(LocalDateTime dataCriacao) { 
        this.dataCriacao = dataCriacao; 
    }
}