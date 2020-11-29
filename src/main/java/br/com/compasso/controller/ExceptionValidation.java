package br.com.compasso.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionValidation extends ResponseEntityExceptionHandler {

	// Metodo responsavel por validar msg de erros de validação
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> erros = ex.getBindingResult().getAllErrors()
				.stream()
				.map(erro -> erro.getDefaultMessage())
				.collect(Collectors.toList());
		
		return ResponseEntity.badRequest().body(erros);				
	}
	
}
