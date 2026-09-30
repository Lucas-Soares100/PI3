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

import com.br.projetoproximaetapa.DAO.ICurso;
import com.br.projetoproximaetapa.model.Curso;

@RestController
@CrossOrigin("*")
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private ICurso dao;

    @GetMapping
    public List<Curso> listaCursos() {
        return (List<Curso>) dao.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Curso> buscarCurso(@PathVariable Integer id) {
        Optional<Curso> curso = dao.findById(id);
        return curso;
    }

    @PostMapping
    public Curso cadastrarCurso(@RequestBody Curso curso) {
        Curso cursoNovo = dao.save(curso);
        return cursoNovo;
    }

    @PutMapping
    public Curso atualizarCurso(@RequestBody Curso curso) {
        Curso cursoAtualizado = dao.save(curso);
        return cursoAtualizado;
    }

    @DeleteMapping("/{id}")
    public Optional<Curso> deletarCurso(@PathVariable Integer id) {
        Optional<Curso> curso = dao.findById(id);
        dao.deleteById(id);
        return curso;
    }
}