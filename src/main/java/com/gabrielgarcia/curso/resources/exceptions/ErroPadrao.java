package com.gabrielgarcia.curso.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErroPadrao implements Serializable{
	private static final long serialVersionUID = 1L;
	  
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") 
	private Instant tempo;
	private Integer status;
	private String erro;
	private String mensagem;
	private String caminho;
	
	public ErroPadrao() {}

	public ErroPadrao(Instant tempo, Integer status, String erro, String mensagem, String caminho) {
		super();
		this.tempo = tempo;
		this.status = status;
		this.erro = erro;
		this.mensagem = mensagem;
		this.caminho = caminho;
	}
	
	public Instant getTempo() {
		return tempo;
	}

	public void setTempo(Instant tempo) {
		this.tempo = tempo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	
}
