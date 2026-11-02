package com.br.projetoproximaetapa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.projetoproximaetapa.model.Encontro;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.Optional;

@Repository 
public interface IEncontro extends JpaRepository<Encontro, String> {
    Optional<Encontro> findEncontroDeHoje(String idCurso, LocalDate dataEncontro);
}