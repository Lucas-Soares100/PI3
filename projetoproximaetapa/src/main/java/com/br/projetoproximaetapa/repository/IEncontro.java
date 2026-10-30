package com.br.projetoproximaetapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.br.projetoproximaetapa.model.Encontro;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository 
public interface IEncontro extends JpaRepository<Encontro, Integer> {
    @Query ("SELECT e FROM Encontro WHERE e.idcurso = :idCurso AND e.dataEncontro =:data")
    Optional<Encontro>findEncontroDeHoje(Integer idCurso, LocalDate data);

}