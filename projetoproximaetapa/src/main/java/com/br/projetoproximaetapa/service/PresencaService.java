package com.br.projetoproximaetapa.service;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
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
String codigoUtilizado;

if (request.getQrCode() != null && !request.getQrCode().trim().isEmpty()) {

    // Registro realizado pela leitura do QR Code
    QRCode qrCode = qrCodeRepository.findById(request.getQrCode())
        .orElseThrow(() -> new IllegalArgumentException(
            "QR Code não encontrado."
        ));

    cpfAluno = qrCode.getCpfAluno();
    idEncontro = qrCode.getIdEncontro();
    codigoUtilizado = qrCode.getQr_code();

} else {

    // Registro manual: utiliza o CPF do aluno e o encontro
    cpfAluno = request.getCpfAluno();
    idEncontro = request.getIdEncontro();

    // Verifica se as informações foram preenchidas
    if (cpfAluno == null || cpfAluno.isBlank()
            || idEncontro == null || idEncontro.isBlank()) {
        throw new IllegalArgumentException(
            "Informe o CPF do aluno e o encontro para registrar manualmente."
        );
    }

    // Busca o QR Code associado ao aluno e ao encontro
    QRCode qrCode = qrCodeRepository
        .findByCpfAlunoAndIdEncontro(cpfAluno, idEncontro)
        .orElseThrow(() -> new IllegalArgumentException(
            "Não existe QR Code cadastrado para este aluno nesta aula."
        ));

    codigoUtilizado = qrCode.getQr_code();
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

        // Verifica se o aluno já possui presença registrada neste encontro
        boolean presencaJaRegistrada = presencaRepository
            .findByIdInscricaoAndIdEncontro(
                inscricao.getIdInscricao(),
             encontro.getIdEncontro()
            )
            .isPresent();

        // Impede que a mesma presença seja registrada novamente
        if (presencaJaRegistrada) {
            throw new IllegalArgumentException(
                "A presença deste aluno já foi registrada nesta aula."
            );
        }

        // Gera um identificador único para o registro de presença
        String idGerado = gerarIdPersonalizado(request.getQrCode(), encontro.getIdEncontro());

        // Cria, configura e salva a presença
        Presenca novaPresenca = new Presenca();
        novaPresenca.setIdPresenca(idGerado);
        novaPresenca.setIdInscricao(inscricao.getIdInscricao());
        novaPresenca.setIdEncontro(encontro.getIdEncontro());
        novaPresenca.setQrCode(codigoUtilizado);
        novaPresenca.setCpfProfessor(request.getCpfProfessor());
        novaPresenca.setStatusPresenca("presente");

        presencaRepository.save(novaPresenca);
    }

   
    // Gera um identificador único para cada registro de presença
    private String gerarIdPersonalizado(String qrCode, String idEncontro) {
        String codigoAleatorio = UUID.randomUUID().toString();
        return "pres-" + codigoAleatorio;
    }

}