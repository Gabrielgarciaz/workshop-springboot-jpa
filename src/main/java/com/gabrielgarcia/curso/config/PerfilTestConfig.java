package com.gabrielgarcia.curso.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabrielgarcia.curso.entities.Usuario;
import com.gabrielgarcia.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class PerfilTestConfig implements CommandLineRunner{
	
	@Autowired // Injeção de dependência
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}
