package com.brq.ecommerce.handlers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.brq.ecommerce.exceptioins.FieldMessageList;
import com.brq.ecommerce.exceptioins.ObjetoNaoEncontradoException;
import com.brq.ecommerce.exceptioins.StandardError;


@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler (MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validador(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		FieldMessageList error = new FieldMessageList(
				 new Date(), HttpStatus.UNPROCESSABLE_ENTITY.value(), 
				"Exceção", 
				"Erro ao validar os dados", 
				request.getRequestURI()
		);
		
		for (FieldError fieldErrorObj: e.getBindingResult().getFieldErrors() ) {
			error.addError(fieldErrorObj.getField(), fieldErrorObj.getDefaultMessage());
		}
				
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(error);
	}
	
	@ExceptionHandler (ObjetoNaoEncontradoException.class)
	public ResponseEntity<StandardError> objetoNaoEncontrado( ObjetoNaoEncontradoException e, HttpServletRequest request ) {
		StandardError error = new StandardError(
				new Date(), 
				HttpStatus.NOT_FOUND.value(), 
				"Objeto Não Encontrado", 
				e.getMessage(), 
				request.getRequestURI()
		);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity <StandardError> runtimeEx(RuntimeException e, HttpServletRequest request){
		StandardError error = new StandardError(
				new Date(), 
				500, 
				"Contate o suporte", 
				e.getMessage(), 
				request.getRequestURI()
		);
		
		return ResponseEntity.status(500).body(error);
		
	}
	
	
	
	
	
	
	
	
	
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<StandardError> validador(MethodArgumentNotValidException e, HttpServletRequest request) {
//	
//		StandardError error = new StandardError(System.currentTimeMillis(), 500, "Exceção", "Erro ao validar dados", request.getRequestURI());
//		
//		return ResponseEntity.status(500).body(error);
//		
//	}
	
//	@ExceptionHandler(ObjetoNaoEncontradoException.class)
//	public ResponseEntity<StandardError> ObjetoNaoEncontrado(ObjetoNaoEncontradoException e, HttpServletRequest request) {
//		
//		StandardError error = new StandardError(System.currentTimeMillis(), 404, "Objeto não encontrado", e.getMessage(), request.getRequestURI());
//		StandardError error = new StandardError(new Date(), 404, "Objeto não encontrado", e.getMessage(), request.getRequestURI());
//		StandardError error = new StandardError(LocalDateTime.now(), 404, "Objeto não encontrado", e.getMessage(), request.getRequestURI());
//		return ResponseEntity.status(404).body(error);
//	}
	
	


}
