package com.br.projetoproximaetapa.DAO;

import org.springframework.data.repository.CrudRepository;
import com.br.projetoproximaetapa.model.Atividade;

public interface IAtividade extends CrudRepository<Atividade, Integer> {
}