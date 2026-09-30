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

import com.br.projetoproximaetapa.DAO.IUniversidade;
import com.br.projetoproximaetapa.model.Universidade;

@RestController
@CrossOrigin("*")
@RequestMapping("/universidades")
public class UniversidadeController {

    @Autowired
    private IUniversidade dao;

    @GetMapping
    public List<Universidade> listaUniversidades() {
        return (List<Universidade>) dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Universidade> buscarUniversidade(@PathVariable Integer id) {
        Optional<Universidade> universidade = dao.findById(id);
        return universidade;
    }

    @PostMapping
    public Universidade cadastrarUniversidade(@RequestBody Universidade universidade) {
        Universidade universidadeNova = dao.save(universidade);
        return universidadeNova;
    }

    @PutMapping
    public Universidade atualizarUniversidade(@RequestBody Universidade universidade) {
        Universidade universidadeAtualizada = dao.save(universidade);
        return universidadeAtualizada;
    }

    @DeleteMapping("/{id}")
    public Optional<Universidade> deletarUniversidade(@PathVariable Integer id) {
        Optional<Universidade> universidade = dao.findById(id);
        dao.deleteById(id);
        return universidade;
    }
}