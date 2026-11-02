package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data 

@Entity
@Table(name = "Presenca")
public class Presenca {

    @Id
    @Column(name = "id_presenca", length = 255)
    private String idPresenca;

    @Column(name = "id_inscricao", nullable = false)
    private Integer idInscricao;

    @Column(name = "id_encontro", nullable = false)
    private Integer idEncontro;

    @Column(name = "cpf_professor", length = 11)
    private String cpfProfessor;

    @Column(name = "status_presenca", length = 20, nullable = false)
    @Pattern(regexp = "Presente | Ausente")
    private String statusPresenca;

    @Column(name = "data_presenca", nullable = false)
    private LocalDateTime dataPresenca = LocalDateTime.now();
}