package com.br.projetoproximaetapa.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.br.projetoproximaetapa.model.Aluno;

public interface IAluno extends CrudRepository<Aluno, Integer> {
    
    @Query("SELECT a FROM Aluno a WHERE a.nome_aluno = :nomeAluno AND a.senha = :senha")
    Aluno findByNomeAlunoAndSenha(@Param("nomeAluno") String nomeAluno, @Param("senha") String senha);
}