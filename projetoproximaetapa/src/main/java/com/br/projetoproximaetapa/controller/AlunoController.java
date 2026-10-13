package com.br.projetoproximaetapa.controller;

import java.util.List;

//import org.springframework.http.HttpStatus;
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

import com.br.projetoproximaetapa.model.Aluno;
//import com.br.projetoproximaetapa.model.LoginRequest;
import com.br.projetoproximaetapa.service.AlunoService;

@RestController
@CrossOrigin ("*")
@RequestMapping ("/alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> listaAlunos() {
        return ResponseEntity.status(200).body(alunoService.listarAlunos());
    }
    
    @GetMapping ("/{id}")
    public ResponseEntity<Aluno> buscarAluno(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(alunoService.buscarAlunoPorId(id));
    }
    
    @PostMapping
    public ResponseEntity<Aluno> cadastrarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(201).body(alunoService.cadastrarAluno(aluno));
    }

    /*@PostMapping("/login")
    public ResponseEntity<Aluno> fazerLogin(@RequestBody LoginRequest loginRequest) {
    
        Aluno alunoEncontrado = dao.findByNomeAlunoAndSenha(loginRequest.getNome_aluno(), loginRequest.getSenha());
        
        if (alunoEncontrado != null) {
            return ResponseEntity.ok(alunoEncontrado); 
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); 
        }
    }*/

    @PutMapping
    public ResponseEntity<Aluno> atualizarAluno(@RequestBody Aluno aluno) {
        return ResponseEntity.status(200).body(alunoService.atualizarAluno(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable Integer id) {
        alunoService.deletarAluno(id);
        return ResponseEntity.status(204).build();
    }

}
