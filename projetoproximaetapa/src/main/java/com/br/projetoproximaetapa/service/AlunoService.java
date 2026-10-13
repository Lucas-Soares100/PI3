package com.br.projetoproximaetapa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.br.projetoproximaetapa.model.Aluno;
import com.br.projetoproximaetapa.repository.IAluno;

@Service
public class AlunoService {
    
    private IAluno alunoRepository;

    public AlunoService(IAluno alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> listarAlunos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos;
    }

    public Aluno buscarAlunoPorId(Integer id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public Aluno cadastrarAluno(Aluno aluno) {
        Aluno alunoNovo = alunoRepository.save(aluno);
        return alunoNovo;
    }

    public Aluno atualizarAluno(Aluno aluno) {
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return alunoAtualizado;
    }

    public Boolean deletarAluno(Integer id) {
        alunoRepository.deleteById(id);
        return true;
    }
}
