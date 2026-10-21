package com.br.projetoproximaetapa.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.projetoproximaetapa.dto.UsuarioDto;
import com.br.projetoproximaetapa.model.Usuario;
import com.br.projetoproximaetapa.repository.IUsuario;
import com.br.projetoproximaetapa.security.Token;
import com.br.projetoproximaetapa.security.TokenUtil;

import jakarta.validation.Valid;

@Service
public class UsuarioService {

    private final IUsuario usuarioRepository;
    private PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuario usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder(); // Inicializa o PasswordEncoder
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorCpf(String cpf) {
        return usuarioRepository.findById(cpf).orElse(null);
    }

    public Usuario cadastrarUsuario(Usuario usuario) {
        String encodedPassword = this.passwordEncoder.encode(usuario.getSenhaHash());
        usuario.setSenhaHash(encodedPassword);
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        String encodedPassword = this.passwordEncoder.encode(usuario.getSenhaHash());
        usuario.setSenhaHash(encodedPassword);
        return usuarioRepository.save(usuario);
    }

    public Boolean deletarUsuario(String cpf) {
        usuarioRepository.deleteById(cpf);
        return true;
    }

    //criptografia de senha
    public Boolean validarSenha(Usuario usuario) {
        String senhaHash = usuarioRepository.findById(usuario.getCpf()).get().getSenhaHash();
        Boolean senhaValida = this.passwordEncoder.matches(usuario.getSenhaHash(), senhaHash);
        return senhaValida;
    }

    public Token gerarToken(@Valid UsuarioDto usuario) {
        Usuario user = usuarioRepository.findByEmail((String) usuario.getEmail());
        if (user !=null){
            Boolean senhaValida = this.passwordEncoder.matches(usuario.getSenhaHash(), user.getSenhaHash());
            if (senhaValida) {
                return new Token(TokenUtil.createToken(user));
            }
        }
        return null;
    }
}