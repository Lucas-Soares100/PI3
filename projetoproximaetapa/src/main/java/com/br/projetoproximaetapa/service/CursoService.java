package com.br.projetoproximaetapa.service;

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

        String idGerado = gerarIdPersonalizado(curso.getNomeCurso(), curso.getDatasCurso(), nomeFaculdade);
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

    private String gerarIdPersonalizado(String nomeCurso, List<LocalDate> datas, String faculdade) {
        String prefixo = nomeCurso != null && nomeCurso.length() >= 4 
            ? nomeCurso.substring(0, 4).toLowerCase() 
            : "curs";

        StringBuilder sbDatas = new StringBuilder();
        if (datas != null) {
            for (LocalDate data : datas) {
                String dia = String.format("%02d", data.getDayOfMonth());
                String mes = String.format("%02d", data.getMonthValue());
                sbDatas.append(dia).append(mes);
            }
        }

        return prefixo + sbDatas.toString() + faculdade;
    }
}