package com.gabrielgarcia.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielgarcia.curso.entities.Produto;
import com.gabrielgarcia.curso.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired // Injeção de dependência
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> obj = produtoRepository.findById(id);
		return obj.get();
	}

}
