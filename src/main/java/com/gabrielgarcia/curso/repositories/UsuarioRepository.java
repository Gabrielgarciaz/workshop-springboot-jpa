package com.gabrielgarcia.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielgarcia.curso.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
}
