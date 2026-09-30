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

import com.br.projetoproximaetapa.DAO.IAtividade;
import com.br.projetoproximaetapa.model.Atividade;

@RestController
@CrossOrigin("*")
@RequestMapping("/atividades")
public class AtividadeController {

    @Autowired
    private IAtividade dao;

    @GetMapping
    public List<Atividade> listaAtividades() {
        return (List<Atividade>) dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Atividade> buscarAtividade(@PathVariable Integer id) {
        Optional<Atividade> atividade = dao.findById(id);
        return atividade;
    }

    @PostMapping
    public Atividade cadastrarAtividade(@RequestBody Atividade atividade) {
        Atividade atividadeNova = dao.save(atividade);
        return atividadeNova;
    }

    @PutMapping
    public Atividade atualizarAtividade(@RequestBody Atividade atividade) {
        Atividade atividadeAtualizada = dao.save(atividade);
        return atividadeAtualizada;
    }

    @DeleteMapping("/{id}")
    public Optional<Atividade> deletarAtividade(@PathVariable Integer id) {
        Optional<Atividade> atividade = dao.findById(id);
        dao.deleteById(id);
        return atividade;
    }
}