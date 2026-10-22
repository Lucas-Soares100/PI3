package com.br.projetoproximaetapa.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    
    @Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable()) // Desativa o CSRF, obrigatório para APIs REST
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/usuarios/login", "/usuarios/cadastro").permitAll() // Libera login e cadastro
            .anyRequest().authenticated() // Qualquer outra rota exige autenticação
        );
    
    return http.build();
    }
}