package com.br.projetoproximaetapa.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.br.projetoproximaetapa.model.Professor;
import com.br.projetoproximaetapa.service.ProfessorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/professores")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listarProfessores() {
        return ResponseEntity.status(200).body(professorService.listarProfessores());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Professor> buscarProfessor(@PathVariable String cpf) {
        return ResponseEntity.status(200).body(professorService.buscarProfessorPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Professor> cadastrarProfessor(@RequestBody Professor professor) {
        return ResponseEntity.status(201).body(professorService.cadastrarProfessor(professor));
    }

    @PutMapping
    public ResponseEntity<Professor> atualizarProfessor(@RequestBody Professor professor) {
        return ResponseEntity.status(200).body(professorService.atualizarProfessor(professor));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> deletarProfessor(@PathVariable String cpf) {
        professorService.deletarProfessor(cpf);
        return ResponseEntity.status(204).build();
    }
}