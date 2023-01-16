package com.gabrielgarcia.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.gabrielgarcia.curso.entities.Usuario;
import com.gabrielgarcia.curso.repositories.UsuarioRepository;
import com.gabrielgarcia.curso.services.exceptions.DataBaseException;
import com.gabrielgarcia.curso.services.exceptions.ResourceNaoEncontradoException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired // Injeção de dependência
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj =  usuarioRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNaoEncontradoException(id)); // Vai tentar retornar obj, caso não encontre lança a exceção
	}
	
	public Usuario inserir(Usuario usuario) {
		return usuarioRepository.save(usuario); // Save por padrão retorna o objeto salvo
	}
	public void deletar(Long id) {
		try {
		usuarioRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNaoEncontradoException(id);
		} catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}
	public Usuario atualizar(Long id, Usuario usuario) {
		try {
			Usuario entity = usuarioRepository.getReferenceById(id);  // Não vai no db, apenas monitora o objeto
			atualizarDados(entity, usuario);
			return usuarioRepository.save(entity);
		}catch(EntityNotFoundException e){
			throw new ResourceNaoEncontradoException(id);
		}
	}

	private void atualizarDados(Usuario entity, Usuario usuario) {
		entity.setNome(usuario.getNome());
		entity.setEmail(usuario.getEmail());
		entity.setTelefone(usuario.getTelefone());
	}
}
