package com.desafiospringboot.catalogodeprodutos.exceptions;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class ProdutoPostError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private int status_code;
	private String message;
	
	
	public ProdutoPostError() {
	}
	
	

	public ProdutoPostError(int status_code, String message) {
		super();
		this.status_code = status_code;
		this.message = message;
	}



	public int getStatus_code() {
		return status_code;
	}

	public void setStatus_code(int status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
