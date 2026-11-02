package com.br.projetoproximaetapa.service;

import java.util.List;
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
        String idGerado = gerarIdPersonalizado(qrCode.getCpfAluno(), qrCode.getIdEncontro());
        qrCode.setQr_code(idGerado);
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
        String cpfLimpo = cpfAluno != null ? cpfAluno.replaceAll("[^0-9]", "") : "";
        String encontroId = idEncontro != null ? idEncontro.trim() : "";
        
        // Adiciona o prefixo "qr" na frente
        return "qr" + cpfLimpo + encontroId;
    }
}