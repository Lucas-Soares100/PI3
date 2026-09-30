package com.br.projetoproximaetapa.DAO;

import org.springframework.data.repository.CrudRepository;
import com.br.projetoproximaetapa.model.Inscricao;

public interface IInscricao extends CrudRepository<Inscricao, Integer> {
}