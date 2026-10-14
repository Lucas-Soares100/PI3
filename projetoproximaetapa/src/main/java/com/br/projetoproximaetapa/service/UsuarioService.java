package com.br.projetoproximaetapa.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.br.projetoproximaetapa.model.Usuario;
import com.br.projetoproximaetapa.repository.IUsuario;

@Service
public class UsuarioService {

    private final IUsuario usuarioRepository;

    public UsuarioService(IUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return usuarioRepository.findById(cpf).orElse(null);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Boolean deletarUsuario(String cpf) {
        usuarioRepository.deleteById(cpf);
        return true;
    }
}