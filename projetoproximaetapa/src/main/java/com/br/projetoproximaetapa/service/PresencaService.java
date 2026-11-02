package com.br.projetoproximaetapa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.br.projetoproximaetapa.model.Presenca;
import com.br.projetoproximaetapa.repository.IPresenca;

@Service
public class PresencaService {

    private final IPresenca presencaRepository;

    public PresencaService(IPresenca presencaRepository) {
        this.presencaRepository = presencaRepository;
    }

    public List<Presenca> listarPresencas() {
        return presencaRepository.findAll();
    }

    public Presenca buscarPresencaPorId(String id) {
        return presencaRepository.findById(id).orElse(null);
    }

    public Presenca cadastrarPresenca(Presenca presenca) {
        // Gera o ID personalizado limpando os prefixos internos e mantendo apenas "presn"
        String idGerado = gerarIdPersonalizado(presenca.getQrCode(), presenca.getIdEncontro());
        presenca.setIdPresenca(idGerado);

        return presencaRepository.save(presenca);
    }

    public Presenca atualizarPresenca(Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    public Boolean deletarPresenca(String id) {
        presencaRepository.deleteById(id);
        return true;
    }

    private String gerarIdPersonalizado(String qrCode, String idEncontro) {
        String qr = qrCode != null ? qrCode.trim() : "";
        String enc = idEncontro != null ? idEncontro.trim() : "";

        // Remove o prefixo "qr" se existir
        String qrSemPrefixo = qr.startsWith("qr") ? qr.substring(2) : qr;

        // Remove o prefixo "enc" do encontro se existir
        String encontroSemPrefixo = enc.startsWith("enc") ? enc.substring(3) : enc;

        // Extrai o CPF do aluno removendo o idEncontro do final da string do QR Code
        String cpfAluno = "";
        if (qrSemPrefixo.endsWith(enc)) {
            cpfAluno = qrSemPrefixo.substring(0, qrSemPrefixo.length() - enc.length());
        } else {
            cpfAluno = qrSemPrefixo;
        }

        // Retorna com o único prefixo "presn"
        return "presn" + cpfAluno + encontroSemPrefixo;
    }
}