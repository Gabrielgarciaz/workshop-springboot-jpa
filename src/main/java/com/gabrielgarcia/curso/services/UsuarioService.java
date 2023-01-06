package com.gabrielgarcia.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielgarcia.curso.entities.Usuario;
import com.gabrielgarcia.curso.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired // Injeção de dependência
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
	Optional<Usuario> obj =  usuarioRepository.findById(id);
	return obj.get();
	}
	
}
