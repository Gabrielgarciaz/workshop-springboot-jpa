package com.gabrielgarcia.curso.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielgarcia.curso.entities.Produto;
import com.gabrielgarcia.curso.services.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> lista = produtoService.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id) { // PathVariable para receber da url
		Produto produtoId = produtoService.findById(id);
		return ResponseEntity.ok().body(produtoId);
	}
}
