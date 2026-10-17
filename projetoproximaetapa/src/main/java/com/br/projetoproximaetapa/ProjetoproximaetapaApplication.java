package com.br.projetoproximaetapa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;

@SpringBootApplication (exclude = {SecurityAutoConfiguration.class})
public class ProjetoproximaetapaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoproximaetapaApplication.class, args);
	}

}
