package com.lnd.custom.error.response.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lnd.custom.error.response.exception.CustomErrorResponse;
import com.lnd.custom.error.response.exception.UserDataNotFoundException;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler
								extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex,
														WebRequest request) {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(
				new Date(), 500, 5001, ex.getMessage());
		return new ResponseEntity<Object>(customErrorResponse,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserDataNotFoundException.class)
	public final ResponseEntity<Object> handleSpcificException(
			UserDataNotFoundException ex, WebRequest request) {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse(
				new Date(), 404, 491, ex.getMessage());
		return new ResponseEntity<Object>(customErrorResponse,
				HttpStatus.NOT_FOUND);
	}
	
}
