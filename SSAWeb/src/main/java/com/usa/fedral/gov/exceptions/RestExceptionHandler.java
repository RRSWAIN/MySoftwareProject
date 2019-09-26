package com.usa.fedral.gov.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler{

	@ExceptionHandler(value=NoStateFoundException.class)
	public ResponseEntity<ApiError> handleNoStateFoundException() {
		ApiError error=new ApiError(400, "NO state Found", new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value=NumberFormatException.class)
	public ResponseEntity<ApiError> handleNoStateFoundException1() {
		ApiError error=new ApiError(400, "invalid state Name", new Date());
		
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
		
	}
}
