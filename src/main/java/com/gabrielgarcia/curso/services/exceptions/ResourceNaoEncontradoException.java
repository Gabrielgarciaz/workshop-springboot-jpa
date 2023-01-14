package com.gabrielgarcia.curso.services.exceptions;

public class ResourceNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceNaoEncontradoException(Object id) { // Id do objeto que tentei encontrar e não encontrei
		super("Recurso não encontrado. Id: " + id);
	}
}
