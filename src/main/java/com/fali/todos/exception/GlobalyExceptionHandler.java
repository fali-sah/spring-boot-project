package com.fali.todos.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalyExceptionHandler {

private static final	Logger LOGGER=LoggerFactory.getLogger(GlobalyExceptionHandler.class);
	 // String s=null;

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String>nullPointerExceptionHandler(NullPointerException ex){
		LOGGER.info("this exception handle by globly");
	//	LOGGER.info("size"+s.length());
		
		
		return new ResponseEntity<>("null pointer Exception is generated"+ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
