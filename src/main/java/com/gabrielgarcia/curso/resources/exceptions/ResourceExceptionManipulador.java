package com.gabrielgarcia.curso.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.gabrielgarcia.curso.services.exceptions.DataBaseException;
import com.gabrielgarcia.curso.services.exceptions.ResourceNaoEncontradoException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // Vai Interceptar exceções par executar possível tratamento
public class ResourceExceptionManipulador {
	
	@ExceptionHandler(ResourceNaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> resourceNaoEncontrado(ResourceNaoEncontradoException e, HttpServletRequest request){
		String erro = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<ErroPadrao> dataBase(DataBaseException e, HttpServletRequest request){
		String erro = "Não pode ser deletado por pertencer a pedidos";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ErroPadrao err = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(status).body(err);
	}
}
