package com.lnd.validation.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class DataNotFoundExecption extends RuntimeException{

	public DataNotFoundExecption(String message) {
		super(message);
	}

}
