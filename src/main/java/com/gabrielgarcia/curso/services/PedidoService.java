package com.gabrielgarcia.curso.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielgarcia.curso.entities.Pedido;
import com.gabrielgarcia.curso.repositories.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired // Injeção de dependência
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll(){
		return pedidoRepository.findAll();
	}
	
	public Pedido findById(Long id) {
	Optional<Pedido> obj =  pedidoRepository.findById(id);
	return obj.get();
	}
	
}
