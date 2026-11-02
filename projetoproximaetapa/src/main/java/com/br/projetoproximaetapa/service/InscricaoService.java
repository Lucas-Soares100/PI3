package com.br.projetoproximaetapa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.br.projetoproximaetapa.model.Inscricao;
import com.br.projetoproximaetapa.repository.IInscricao;

@Service
public class InscricaoService {

    private final IInscricao inscricaoRepository;

    public InscricaoService(IInscricao inscricaoRepository) {
        this.inscricaoRepository = inscricaoRepository;
    }

    public List<Inscricao> listarInscricoes() {
        return inscricaoRepository.findAll();
    }

    public Inscricao buscarInscricaoPorId(String id) {
        return inscricaoRepository.findById(id).orElse(null);
    }

    public Inscricao cadastrarInscricao(Inscricao inscricao) {
        String idGerado = gerarIdPersonalizado(inscricao.getCpfAluno(), inscricao.getIdCurso());
        inscricao.setIdInscricao(idGerado);
        return inscricaoRepository.save(inscricao);
    }

    public Inscricao atualizarInscricao(Inscricao inscricao) {
        return inscricaoRepository.save(inscricao);
    }

    public Boolean deletarInscricao(String id) {
        inscricaoRepository.deleteById(id);
        return true;
    }

    private String gerarIdPersonalizado(String cpfAluno, String idCurso) {
        String cpfLimpo = cpfAluno != null ? cpfAluno.replaceAll("[^0-9]", "") : "";
        String cursoId = idCurso != null ? idCurso.trim() : "";
        
        // Adiciona o prefixo "ins" na frente
        return "ins" + cpfLimpo + cursoId;
    }
}