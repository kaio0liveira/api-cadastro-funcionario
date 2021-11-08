package com.api.cadastro.funcionario.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.api.cadastro.funcionario.entity.*;
import com.api.cadastro.funcionario.exception.NotFoundException;

@RestController
@ControllerAdvice
public class GlobalJavaExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorObject> handleDiffControllerExceptions(NotFoundException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorObject(e.getMessage()));
	}
	
	
}