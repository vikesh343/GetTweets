package com.algoworks.tweets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algoworks.tweets.response.ApplicationError;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomApplicationException.class)
	public ResponseEntity<Object> customException(CustomApplicationException ex){
		ApplicationError error = new ApplicationError();
		error.setErrorCode("1");
		error.setErrorDescription(ex.getMessage());	
		return new ResponseEntity<>(error, HttpStatus.OK);
	}
	
	
}
