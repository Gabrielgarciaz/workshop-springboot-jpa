package com.gabrielgarcia.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabrielgarcia.curso.entities.Categoria;
import com.gabrielgarcia.curso.entities.Pedido;
import com.gabrielgarcia.curso.entities.Usuario;
import com.gabrielgarcia.curso.entities.enums.PedidoStatus;
import com.gabrielgarcia.curso.repositories.CategoriaRepository;
import com.gabrielgarcia.curso.repositories.PedidoRepository;
import com.gabrielgarcia.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class PerfilTestConfig implements CommandLineRunner{
	
	@Autowired // Injeção de dependência
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		
		Pedido p1 = new Pedido(null, Instant.parse("2022-01-20T19:53:07Z"), PedidoStatus.AGUARDANDO_PAGAMENTO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2023-12-20T19:53:07Z"), PedidoStatus.CANCELADO, u1);
		Pedido p3 = new Pedido(null, Instant.parse("2020-08-10T19:53:07Z"), PedidoStatus.PAGO, u2);
		
		pedidoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		
		Categoria c1 = new Categoria(null, "Notebook");
		Categoria c2 = new Categoria(null, "Celular");
		Categoria c3 = new Categoria(null, "Livro");
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3));
	}
}
