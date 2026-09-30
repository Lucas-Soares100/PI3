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
    public List<Aluno> listaAlunos() {
        return (List<Aluno>) dao.findAll();
    }
    
    @GetMapping ("/{id}")
    public Optional<Aluno> buscarAluno(@PathVariable Integer id) {
        Optional<Aluno> aluno = dao.findById(id);
        return aluno;
    }

    @PostMapping("/cadastrar") 
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        Aluno alunoNovo = dao.save(aluno);
        return alunoNovo;
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
    public Aluno atualizarAluno(@RequestBody Aluno aluno) {
        Aluno alunoAtualizado = dao.save(aluno);
        return alunoAtualizado;
    }

    @DeleteMapping("/{id}")
    public Optional<Aluno> deletarAluno(@PathVariable Integer id) {
        Optional<Aluno> aluno = dao.findById(id);
        dao.deleteById(id);
        return aluno;
    }

}
