package com.br.projetoproximaetapa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.projetoproximaetapa.DAO.IAluno;
import com.br.projetoproximaetapa.model.Aluno;
import com.br.projetoproximaetapa.model.LoginRequest;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/alunos")
public class AlunoController {

    @Autowired
    private IAluno dao;

    @GetMapping
    public ResponseEntity<List<Aluno>> listaAlunos() {
        List<Aluno> listaalunos = (List<Aluno>) dao.findAll();
        return ResponseEntity.status(200).body(listaalunos);
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Optional<Aluno>> buscarAluno(@PathVariable Integer id) {
        Optional<Aluno> aluno = dao.findById(id);
        return ResponseEntity.status(200).body(aluno);
    }

    @PostMapping("/cadastrar") 
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno alunoNovo = dao.save(aluno);
        return ResponseEntity.status(201).body(alunoNovo);
    }

    @PostMapping("/login")
    public ResponseEntity<Aluno> fazerLogin(@RequestBody LoginRequest loginRequest) {
    
        Aluno alunoEncontrado = dao.findByNomeAlunoAndSenha(loginRequest.getNome_aluno(), loginRequest.getSenha());
        
        if (alunoEncontrado != null) {
            return ResponseEntity.ok(alunoEncontrado); 
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }

    @PutMapping
    public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno aluno) {
        Aluno alunoAtualizado = dao.save(aluno);
        return ResponseEntity.status(201).body(alunoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Integer id) {
        dao.deleteById(id);
        return ResponseEntity.status(204).build();
    }

}
