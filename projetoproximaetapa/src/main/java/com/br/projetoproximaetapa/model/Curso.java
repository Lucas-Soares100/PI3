package com.br.projetoproximaetapa.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import lombok.Data;

@Data 

@Entity
@Table(name = "Curso")
public class Curso {

    @Id
    @Column(name = "id_curso", length = 150, nullable = false)
    private String idCurso;

    @Column(name = "id_atividade", nullable = false)
    private Integer idAtividade;

    @Column(name = "id_universidade", nullable = false)
    private Integer idUniversidade;

    @Column(name = "cpf_professor", length = 11)
    private String cpfProfessor;

    @Column(name = "nome_curso", length = 150, nullable = false)
    private String nomeCurso;

    @Column(name = "descricao_curso", columnDefinition = "TEXT", nullable = false)
    private String descricaoCurso;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "datas_curso", columnDefinition = "JSON", nullable = false)
    private List<LocalDate> datasCurso;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(name = "horarios_curso", columnDefinition = "JSON", nullable = false)
    private List<LocalTime> horariosCurso;

    @Column(name = "local_curso", length = 150, nullable = false)
    private String localCurso;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "quantidade_aula", nullable = false)
    private Integer quantidadeAula;
}