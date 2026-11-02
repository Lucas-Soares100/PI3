package com.br.projetoproximaetapa.service;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.br.projetoproximaetapa.model.Curso;
import com.br.projetoproximaetapa.model.Universidade;
import com.br.projetoproximaetapa.repository.ICurso;
import com.br.projetoproximaetapa.repository.IUniversidade;

@Service
public class CursoService {

    private final ICurso cursoRepository;
    private final IUniversidade universidadeRepository;

    public CursoService(ICurso cursoRepository, IUniversidade universidadeRepository) {
        this.cursoRepository = cursoRepository;
        this.universidadeRepository = universidadeRepository;
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso buscarCursoPorId(String id) {
        return cursoRepository.findById(id).orElse(null);
    }

    public Curso cadastrarCurso(Curso curso) {
        Universidade universidade = universidadeRepository.findById(curso.getIdUniversidade()).orElse(null);
        String nomeFaculdade = universidade != null ? universidade.getNomeUniversidade().replaceAll("\\s+", "") : "EXT";

        String idGerado = gerarIdPersonalizado(curso.getNomeCurso(), curso.getDiaSemana(), nomeFaculdade, curso.getQuantidadeAula());
        curso.setIdCurso(idGerado);

        return cursoRepository.save(curso);
    }

    public Curso atualizarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Boolean deletarCurso(String id) {
        cursoRepository.deleteById(id);
        return true;
    }

    private String gerarIdPersonalizado(String nomeCurso, String faculdade, String diaSemana, Integer quantidadeAula) {
        // 1. Primeiras 4 letras do curso (normalizadas e minúsculas)
        String prefixoCurso = (nomeCurso != null && nomeCurso.length() >= 4) 
            ? removerAcentos(nomeCurso).substring(0, 4).toLowerCase() 
            : (nomeCurso != null ? removerAcentos(nomeCurso).toLowerCase() : "curs");
        
        // 2. Nome da faculdade limpo (sem espaços ou acentos, ex: "FECAP" -> "fecap")
        String limpaFaculdade = (faculdade != null) 
            ? removerAcentos(faculdade).replaceAll("[^a-zA-Z0-9]", "").toLowerCase() 
            : "ext";
        
        // 3. Dia da semana limpo (ex: "Segunda-Feira" -> "segunda")
        String limpaDia = "";
        if (diaSemana != null) {
            limpaDia = removerAcentos(diaSemana).toLowerCase()
                .replace("-feira", "")
                .replaceAll("[^a-zA-Z0-9]", "");
        }
        
        // 4. Quantidade de aulas (número final, ex: 2)
        String qtd = (quantidadeAula != null) ? quantidadeAula.toString() : "";

        return prefixoCurso + limpaFaculdade + limpaDia + qtd;
    }

    // Auxiliar para remover acentos de strings (ex: "Terça" -> "terca")
    private String removerAcentos(String str) {
        if (str == null) return "";
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
        return nfdNormalizedString.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}