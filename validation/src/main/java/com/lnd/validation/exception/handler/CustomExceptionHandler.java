package com.lnd.validation.exception.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lnd.validation.entities.CustomErrorResponseEntity;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		CustomErrorResponseEntity customErrorResponseEntity 
						= new CustomErrorResponseEntity(new Date(), 400, 4001,
								ex.getLocalizedMessage());

		return new ResponseEntity<Object>(customErrorResponseEntity,
				HttpStatus.BAD_REQUEST);		
	}
	
}
