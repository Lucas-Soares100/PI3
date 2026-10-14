package com.br.projetoproximaetapa.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.br.projetoproximaetapa.model.Administrador;
import com.br.projetoproximaetapa.service.AdministradorService;

@RestController
@CrossOrigin("*")
@RequestMapping("/administradores")
public class AdministradorController {

    private final AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @GetMapping
    public ResponseEntity<List<Administrador>> listarAdministradores() {
        return ResponseEntity.status(200).body(administradorService.listarAdministradores());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Administrador> buscarAdministrador(@PathVariable String cpf) {
        return ResponseEntity.status(200).body(administradorService.buscarAdministradorPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Administrador> cadastrarAdministrador(@RequestBody Administrador administrador) {
        return ResponseEntity.status(201).body(administradorService.cadastrarAdministrador(administrador));
    }

    @PutMapping
    public ResponseEntity<Administrador> atualizarAdministrador(@RequestBody Administrador administrador) {
        return ResponseEntity.status(200).body(administradorService.atualizarAdministrador(administrador));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> deletarAdministrador(@PathVariable String cpf) {
        administradorService.deletarAdministrador(cpf);
        return ResponseEntity.status(204).build();
    }
}