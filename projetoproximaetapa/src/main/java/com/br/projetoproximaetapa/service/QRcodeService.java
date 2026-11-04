package com.br.projetoproximaetapa.service;

import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.br.projetoproximaetapa.model.QRCode;
import com.br.projetoproximaetapa.repository.IQRCode;

@Service
public class QRcodeService {

    private final IQRCode qrCodeRepository;

    public QRcodeService(IQRCode qrCodeRepository) {
        this.qrCodeRepository = qrCodeRepository;
    }

    public List<QRCode> listarQRCodes() {
        return qrCodeRepository.findAll();
    }

    public QRCode buscarQRCodePorId(String id) {
        return qrCodeRepository.findById(id).orElse(null);
    }

    
    public QRCode cadastrarQRCode(QRCode qrCode) {

        // Verifica se já existe um QR Code para o aluno nesta aula
        QRCode codigoExistente = qrCodeRepository
            .findByCpfAlunoAndIdEncontro(
                qrCode.getCpfAluno(),
                qrCode.getIdEncontro()
            )
            .orElse(null);

        // Se já existe, reutiliza o mesmo QR Code
        if (codigoExistente != null) {
            return codigoExistente;
        }

        // Se não existe, gera um novo identificador
        String idGerado = gerarIdPersonalizado(
            qrCode.getCpfAluno(),
            qrCode.getIdEncontro()
        );

        qrCode.setQr_code(idGerado);

        // Salva o novo QR Code no banco de dados
            return qrCodeRepository.save(qrCode);
        }

    public QRCode atualizarQRCode(QRCode qrCode) {
            return qrCodeRepository.save(qrCode);
        }

        public Boolean deletarQRCode(String id) {
            qrCodeRepository.deleteById(id);
            return true;
        }

   
    private String gerarIdPersonalizado(String cpfAluno, String idEncontro) {
        String codigoAleatorio = UUID.randomUUID().toString();
        return "qr-" + codigoAleatorio;
}

}