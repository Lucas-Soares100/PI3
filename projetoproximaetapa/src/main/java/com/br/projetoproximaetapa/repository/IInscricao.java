package com.br.projetoproximaetapa.repository;

import com.br.projetoproximaetapa.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface IInscricao extends JpaRepository<Inscricao, Integer> {
    Optional<Inscricao> findByQrCode(String qrCode);
}