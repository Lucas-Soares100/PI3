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

import com.br.projetoproximaetapa.DAO.IPresenca;
import com.br.projetoproximaetapa.model.Presenca;

@RestController
@CrossOrigin("*")
@RequestMapping("/presencas")
public class PresencaController {

    @Autowired
    private IPresenca dao;

    @GetMapping
    public List<Presenca> listaPresencas() {
        return (List<Presenca>) dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Presenca> buscarPresenca(@PathVariable Integer id) {
        Optional<Presenca> presenca = dao.findById(id);
        return presenca;
    }

    @PostMapping
    public Presenca cadastrarPresenca(@RequestBody Presenca presenca) {
        Presenca presencaNova = dao.save(presenca);
        return presencaNova;
    }

    @PutMapping
    public Presenca atualizarPresenca(@RequestBody Presenca presenca) {
        Presenca presencaAtualizada = dao.save(presenca);
        return presencaAtualizada;
    }

    @DeleteMapping("/{id}")
    public Optional<Presenca> deletarPresenca(@PathVariable Integer id) {
        Optional<Presenca> presenca = dao.findById(id);
        dao.deleteById(id);
        return presenca;
    }
}