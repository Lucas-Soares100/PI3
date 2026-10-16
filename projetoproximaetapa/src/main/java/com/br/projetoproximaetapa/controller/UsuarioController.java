package com.br.projetoproximaetapa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.br.projetoproximaetapa.model.Usuario;
import com.br.projetoproximaetapa.service.UsuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return ResponseEntity.status(200).body(usuarioService.listarUsuarios());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Usuario> buscarUsuario(@PathVariable String cpf) {
        return ResponseEntity.status(200).body(usuarioService.buscarUsuarioPorCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.cadastrarUsuario(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.status(200).body(usuarioService.atualizarUsuario(usuario));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> deletarUsuario(@PathVariable String cpf) {
        usuarioService.deletarUsuario(cpf);
        return ResponseEntity.status(204).build();
    }

//Login com criptografia de senha
    @PostMapping("/login")
    public ResponseEntity<Usuario> validarSenha(@RequestBody Usuario usuario) {
        Boolean senhaValida = usuarioService.validarSenha(usuario);
        if (!senhaValida) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Retorna 401 Unauthorized se a senha for inválida
        }
        return ResponseEntity.status(200).build(); // Retorna 200 OK se a senha for válida
    }

}