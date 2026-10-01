package com.br.projetoproximaetapa.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projetoproximaetapa.DAO.IInscricao;
import com.br.projetoproximaetapa.model.Inscricao;

@RestController
@CrossOrigin("*")
@RequestMapping("/inscricoes")
public class InscricaoController {

    @Autowired
    private IInscricao dao;

    @GetMapping
    public List<Inscricao> listaInscricoes() {
        return (List<Inscricao>) dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Inscricao> buscarInscricao(@PathVariable Integer id) {
        Optional<Inscricao> inscricao = dao.findById(id);
        return inscricao;
    }

    @PostMapping
    public Inscricao cadastrarInscricao(@RequestBody Inscricao inscricao) {
        Inscricao inscricaoNova = dao.save(inscricao);
        return inscricaoNova;
    }

    @PutMapping
    public Inscricao atualizarInscricao(@RequestBody Inscricao inscricao) {
        Inscricao inscricaoAtualizada = dao.save(inscricao);
        return inscricaoAtualizada;
    }

    @DeleteMapping("/{id}")
    public Optional<Inscricao> deletarInscricao(@PathVariable Integer id) {
        Optional<Inscricao> inscricao = dao.findById(id);
        dao.deleteById(id);
        return inscricao;
    }
}