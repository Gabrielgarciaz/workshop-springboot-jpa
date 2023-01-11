package com.gabrielgarcia.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielgarcia.curso.entities.Categoria;
import com.gabrielgarcia.curso.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired // Injeção de dependência
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj =  categoriaRepository.findById(id);
		return obj.get();
	}
	
}
