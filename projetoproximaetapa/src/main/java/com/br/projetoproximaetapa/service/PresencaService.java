package com.br.projetoproximaetapa.service;

import java.time.LocalDate;
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

    private final IQRCode qrCodeRepository;
    private final IEncontro encontroRepository;
    private final IInscricao inscricaoRepository;
    private final IPresenca presencaRepository;

    public PresencaService(IQRCode qrCodeRepository, IEncontro encontroRepository, 
                           IInscricao inscricaoRepository, IPresenca presencaRepository) {
        this.qrCodeRepository = qrCodeRepository;
        this.encontroRepository = encontroRepository;
        this.inscricaoRepository = inscricaoRepository;
        this.presencaRepository = presencaRepository;
    }

    public void registrarPresenca(PresencaRequestDTO request) {
        String cpfAluno;
        String idEncontro;

        // 1. Busca opcional por QR Code
        if (request.getQrCode() != null && !request.getQrCode().trim().isEmpty()) {
            QRCode qrCode = qrCodeRepository.findById(request.getQrCode())
                .orElseThrow(() -> new RuntimeException("Erro: QR Code inválido ou não encontrado."));
            cpfAluno = qrCode.getCpfAluno();
            idEncontro = qrCode.getIdEncontro();
        } else {
            cpfAluno = request.getCpfAluno();
            idEncontro = request.getIdEncontro();
        }

        // 2. Busca e valida o Encontro
        Encontro encontro = encontroRepository.findById(idEncontro)
            .orElseThrow(() -> new RuntimeException("Erro: Encontro não encontrado."));

        // 3. Valida se a data do encontro corresponde ao dia de hoje
        if (!encontro.getDataEncontro().equals(LocalDate.now())) {
            throw new RuntimeException("Erro: Não existe aula agendada para hoje.");
        }

        // 4. Valida a Inscrição do aluno para o curso correspondente
        Inscricao inscricao = inscricaoRepository.findByCpfAlunoAndIdCurso(cpfAluno, encontro.getIdCurso())
            .orElseThrow(() -> new RuntimeException("Erro: Aluno não inscrito neste curso."));

        // 5. Gera o ID personalizado utilizando a sua lógica de remoção de prefixos
        String idGerado = gerarIdPersonalizado(request.getQrCode(), encontro.getIdEncontro());

        // 6. Cria, configura e salva a presença
        Presenca novaPresenca = new Presenca();
        novaPresenca.setIdPresenca(idGerado);
        novaPresenca.setIdInscricao(inscricao.getIdInscricao());
        novaPresenca.setIdEncontro(encontro.getIdEncontro());
        novaPresenca.setCpfProfessor(request.getCpfProfessor());
        novaPresenca.setStatusPresenca("presente");

        presencaRepository.save(novaPresenca);
    }

    // Método privado com a sua lógica personalizada de prefixos
    private String gerarIdPersonalizado(String qrCode, String idEncontro) {
        String qr = qrCode != null ? qrCode.trim() : "";
        String enc = idEncontro != null ? idEncontro.trim() : "";

        // Remove o prefixo "qr" se existir
        String qrSemPrefixo = qr.startsWith("qr") ? qr.substring(2) : qr;

        // Remove o prefixo "enc" do encontro se existir
        String encontroSemPrefixo = enc.startsWith("enc") ? enc.substring(3) : enc;

        // Extrai o CPF do aluno removendo o idEncontro do final da string do QR Code
        String cpfAluno = "";
        if (qrSemPrefixo.endsWith(encontroSemPrefixo) || qrSemPrefixo.endsWith(enc)) {
            String sufixoParaRemover = qrSemPrefixo.endsWith(enc) ? enc : encontroSemPrefixo;
            cpfAluno = qrSemPrefixo.substring(0, qrSemPrefixo.length() - sufixoParaRemover.length());
        } else {
            cpfAluno = qrSemPrefixo;
        }

        // Retorna com o prefixo "presn" (ou "pres", conforme preferir)
        return "presn" + cpfAluno + encontroSemPrefixo;
    }
}