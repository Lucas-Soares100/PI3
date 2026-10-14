package com.br.projetoproximaetapa.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.br.projetoproximaetapa.model.Aluno;
import com.br.projetoproximaetapa.service.AlunoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listarAlunos() {
        return ResponseEntity.status(200).body(alunoService.listarAlunos());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable String cpf) {
        return ResponseEntity.status(200).body(alunoService.buscarAlunoPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(201).body(alunoService.cadastrarAluno(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(200).body(alunoService.atualizarAluno(aluno));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> deletarAluno(@PathVariable String cpf) {
        alunoService.deletarAluno(cpf);
        return ResponseEntity.status(204).build();
    }
}