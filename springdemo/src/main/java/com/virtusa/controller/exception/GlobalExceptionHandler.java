package com.virtusa.controller.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(value=NullPointerException.class)
	public String exceptionNull() {
		return "NullPointerException";
	}
	
	@ExceptionHandler(value=IOException.class)
	public String exceptionIO() {
		return "IOException";
	}
	
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String exception() {
		return "Exception";
	}
}
