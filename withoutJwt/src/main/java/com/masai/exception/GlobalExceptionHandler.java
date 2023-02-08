package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyError> CustomerExceptionHandler(CustomerException ce, WebRequest req){
		
		MyError me=new MyError(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> ExceptionHandler(Exception ce, WebRequest req){
		
		MyError me=new MyError(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError> ExceptionHandler(NoHandlerFoundException ce, WebRequest req){
		
		MyError me=new MyError(LocalDateTime.now(), ce.getMessage(), req.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
		
	}
	
}
