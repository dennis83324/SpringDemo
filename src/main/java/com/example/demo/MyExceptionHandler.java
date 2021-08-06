package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle (Exception exception){
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
				.body("Exception : " + exception.getMessage());
	}
}
