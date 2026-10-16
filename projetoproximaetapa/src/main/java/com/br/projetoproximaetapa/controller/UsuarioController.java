package com.br.projetoproximaetapa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import com.br.projetoproximaetapa.model.Usuario;
import com.br.projetoproximaetapa.service.UsuarioService;

import jakarta.validation.Valid;

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
    public ResponseEntity<Usuario> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(201).body(usuarioService.cadastrarUsuario(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> atualizarUsuario(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.status(200).body(usuarioService.atualizarUsuario(usuario));
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<?> deletarUsuario(@PathVariable String cpf) {
        usuarioService.deletarUsuario(cpf);
        return ResponseEntity.status(204).build();
    }

//Login com criptografia de senha
    @PostMapping("/login")
    public ResponseEntity<Usuario> validarSenha(@Valid @RequestBody Usuario usuario) {
        Boolean senhaValida = usuarioService.validarSenha(usuario);
        if (!senhaValida) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build(); // Retorna 401 Unauthorized se a senha for inválida
        }
        return ResponseEntity.status(200).build(); // Retorna 200 OK se a senha for válida
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}