package com.br.projetoproximaetapa.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.br.projetoproximaetapa.dto.PresencaRequestDTO;
import com.br.projetoproximaetapa.model.Encontro;
import com.br.projetoproximaetapa.model.Inscricao;
import com.br.projetoproximaetapa.model.Presenca;
import com.br.projetoproximaetapa.model.QRCode;
import com.br.projetoproximaetapa.repository.IEncontro;
import com.br.projetoproximaetapa.repository.IInscricao;
import com.br.projetoproximaetapa.repository.IPresenca;
import com.br.projetoproximaetapa.repository.IQRCode;

@Service
public class PresencaService {

    private final IPresenca presencaRepository;
    private final IQRCode qrCodeRepository;
    private final IEncontro encontroRepository;
    private final IInscricao inscricaoRepository;

    public PresencaService(IPresenca presencaRepository, IQRCode qrCodeRepository, 
                           IEncontro encontroRepository, IInscricao inscricaoRepository) {
        this.presencaRepository = presencaRepository;
        this.qrCodeRepository = qrCodeRepository;
        this.encontroRepository = encontroRepository;
        this.inscricaoRepository = inscricaoRepository;
    }

    // 1. Métodos CRUD padrão (para o PresencaController não dar erro de símbolo)
    public List<Presenca> listarPresencas() {
        return presencaRepository.findAll();
    }

    public Presenca buscarPresencaPorId(String id) {
        return presencaRepository.findById(id).orElse(null);
    }

    public Presenca cadastrarPresenca(Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    public Presenca atualizarPresenca(Presenca presenca) {
        return presencaRepository.save(presenca);
    }

    public Boolean deletarPresenca(String id) {
        presencaRepository.deleteById(id);
        return true;
    }

    // 2. Lógica personalizada para registrar presença (com QR Code opcional e ID customizado)
    public void registrarPresenca(PresencaRequestDTO request) {
        String cpfAluno;
        String idEncontro;

        // Busca opcional por QR Code usando o findById nativo
        if (request.getQrCode() != null && !request.getQrCode().trim().isEmpty()) {
            QRCode qrCode = qrCodeRepository.findById(request.getQrCode())
                .orElseThrow(() -> new RuntimeException("Erro: QR Code inválido ou não encontrado."));
            cpfAluno = qrCode.getCpfAluno();
            idEncontro = qrCode.getIdEncontro();
        } else {
            cpfAluno = request.getCpfAluno();
            idEncontro = request.getIdEncontro();
        }

        // Busca e valida o Encontro
        Encontro encontro = encontroRepository.findById(idEncontro)
            .orElseThrow(() -> new RuntimeException("Erro: Encontro não encontrado."));

        // Valida se a data do encontro corresponde ao dia de hoje
        if (!encontro.getDataEncontro().equals(LocalDate.now())) {
            throw new RuntimeException("Erro: Não existe aula agendada para hoje.");
        }

        // Valida a Inscrição do aluno para o curso correspondente
        Inscricao inscricao = inscricaoRepository.findByCpfAlunoAndIdCurso(cpfAluno, encontro.getIdCurso())
            .orElseThrow(() -> new RuntimeException("Erro: Aluno não inscrito neste curso."));

        // Gera o ID personalizado utilizando a sua lógica de remoção de prefixos
        String idGerado = gerarIdPersonalizado(request.getQrCode(), encontro.getIdEncontro());

        // Cria, configura e salva a presença
        Presenca novaPresenca = new Presenca();
        novaPresenca.setIdPresenca(idGerado);
        novaPresenca.setIdInscricao(inscricao.getIdInscricao());
        novaPresenca.setIdEncontro(encontro.getIdEncontro());
        novaPresenca.setCpfProfessor(request.getCpfProfessor());
        novaPresenca.setStatusPresenca("presente");

        presencaRepository.save(novaPresenca);
    }

    // Método privado com a lógica personalizada de prefixos
    private String gerarIdPersonalizado(String qrCode, String idEncontro) {
        String qr = qrCode != null ? qrCode.trim() : "";
        String enc = idEncontro != null ? idEncontro.trim() : "";

        String qrSemPrefixo = qr.startsWith("qr") ? qr.substring(2) : qr;
        String encontroSemPrefixo = enc.startsWith("enc") ? enc.substring(3) : enc;

        String cpfAluno = "";
        if (qrSemPrefixo.endsWith(encontroSemPrefixo) || qrSemPrefixo.endsWith(enc)) {
            String sufixoParaRemover = qrSemPrefixo.endsWith(enc) ? enc : encontroSemPrefixo;
            cpfAluno = qrSemPrefixo.substring(0, qrSemPrefixo.length() - sufixoParaRemover.length());
        } else {
            cpfAluno = qrSemPrefixo;
        }

        return "presn" + cpfAluno + encontroSemPrefixo;
    }
}