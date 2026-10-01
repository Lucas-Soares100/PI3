package com.br.projetoproximaetapa.DAO;

import org.springframework.data.repository.CrudRepository;
import com.br.projetoproximaetapa.model.Presenca;

public interface IPresenca extends CrudRepository<Presenca, Integer> {
}