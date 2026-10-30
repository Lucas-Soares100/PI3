package com.br.projetoproximaetapa.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.br.projetoproximaetapa.model.Presenca;
import com.br.projetoproximaetapa.service.PresencaService;
import com.br.projetoproximaetapa.model.Inscricao;
import com.br.projetoproximaetapa.model.Encontro;
import com.br.projetoproximaetapa.repository.IInscricao;
import com.br.projetoproximaetapa.repository.IEncontro; 
import com.br.projetoproximaetapa.dto.PresencaRequestDTO; 
import java.time.LocalDate;
import java.util.Optional;




@RestController
@CrossOrigin("*")
@RequestMapping("/presencas")


public class PresencaController {

    private final PresencaService presencaService;
    private final IInscricao inscricaoRepository;
    private final IEncontro encontroRepository;

    public PresencaController(PresencaService presencaService, IInscricao inscricaoRepository, IEncontro encontroRepository) {
        this.presencaService = presencaService;
        this.inscricaoRepository = inscricaoRepository;
        this.encontroRepository = encontroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Presenca>> listarPresencas() {
        return ResponseEntity.status(200).body(presencaService.listarPresencas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Presenca> buscarPresenca(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(presencaService.buscarPresencaPorId(id));
    }

    @PostMapping
    public ResponseEntity<Presenca> cadastrarPresenca(@RequestBody Presenca presenca) {
        return ResponseEntity.status(201).body(presencaService.cadastrarPresenca(presenca));
    }

    @PutMapping
    public ResponseEntity<Presenca> atualizarPresenca(@RequestBody Presenca presenca) {
        return ResponseEntity.status(200).body(presencaService.atualizarPresenca(presenca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPresenca(@PathVariable Integer id) {
        presencaService.deletarPresenca(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/ler-qrcode")
    public ResponseEntity<String> registrarPresencaPorQrCode(@RequestBody PresencaRequestDTO request) {

      
        Optional<Inscricao> inscricaoOpt = inscricaoRepository.findByQrCode(request.getQrCode());
        if (inscricaoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Erro: QR Code inválido ou inscrição não encontrada.");
        }
        Inscricao inscricao = inscricaoOpt.get();


        LocalDate hoje = LocalDate.now();
        Optional<Encontro> encontroOpt = encontroRepository.findEncontroDeHoje(inscricao.getIdCurso(), hoje);
        if (encontroOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Erro: Não existe aula agendada para este curso na data de hoje.");
        }
        Encontro encontro = encontroOpt.get();

 
        Presenca novaPresenca = new Presenca();
        novaPresenca.setIdInscricao(inscricao.getIdInscricao());
        novaPresenca.setIdEncontro(encontro.getIdEncontro());
        novaPresenca.setCpfProfessor(request.getCpfProfessor());
        novaPresenca.setStatusPresenca("presente");

   
        presencaService.cadastrarPresenca(novaPresenca);

        return ResponseEntity.status(201).body("Presença registada com sucesso para o aluno!");
    }
}
    
