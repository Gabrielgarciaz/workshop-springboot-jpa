package com.gabrielgarcia.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.gabrielgarcia.curso.entities.Categoria;
import com.gabrielgarcia.curso.entities.Pedido;
import com.gabrielgarcia.curso.entities.Produto;
import com.gabrielgarcia.curso.entities.Usuario;
import com.gabrielgarcia.curso.entities.enums.PedidoStatus;
import com.gabrielgarcia.curso.repositories.CategoriaRepository;
import com.gabrielgarcia.curso.repositories.PedidoRepository;
import com.gabrielgarcia.curso.repositories.ProdutoRepository;
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
	
	@Autowired
	private ProdutoRepository produtoRepository;

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
		Categoria c4 = new Categoria(null, "Eletronicos");
		
		categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		
		Produto pr1 = new Produto(null, "Iphone Xr", "60gb", 3000.0, "");
		Produto pr2 = new Produto(null, "Dell G15", "RTX3050", 6000.0, "");
		Produto pr3 = new Produto(null, "Código Limpo", "Livro para Desenvolvedores", 300.0, "");
		Produto pr4 = new Produto(null, "Tablet", "Tela grande", 1000.0, "");
		
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4));
		
		
		pr1.getCategorias().add(c2); // Associação entre os objetos
		pr1.getCategorias().add(c4);
		pr2.getCategorias().add(c1);
		pr2.getCategorias().add(c4);
		pr3.getCategorias().add(c3);
		pr4.getCategorias().add(c4);
		
		produtoRepository.saveAll(Arrays.asList(pr1, pr2, pr3, pr4));
		
		
		
	}
}
