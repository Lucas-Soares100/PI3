package com.br.projetoproximaetapa.repository;

import org.springframework.data.repository.CrudRepository;
import com.br.projetoproximaetapa.model.Curso;

public interface ICurso extends CrudRepository<Curso, Integer> {
}