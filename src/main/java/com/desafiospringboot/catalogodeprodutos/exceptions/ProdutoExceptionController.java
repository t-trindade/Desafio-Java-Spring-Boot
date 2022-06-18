package com.desafiospringboot.catalogodeprodutos.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProdutoExceptionController {
	
	// Erro personalizado POST
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ProdutoPostError> postValidation(MethodArgumentNotValidException e){
		
		List<FieldError> fieldErros = e.getFieldErrors();
		ProdutoPostError err = new ProdutoPostError();	
		
		for(FieldError erros : fieldErros) {	
			err.setMessage("O campo " + erros.getField() + " deve ser preenchido!");
			err.setStatus_code(HttpStatus.BAD_REQUEST.value());	
		}	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
}

