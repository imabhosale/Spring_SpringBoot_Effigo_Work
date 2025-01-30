package com.abhi.restful_web_services.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CutsomizedResponceEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex,WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler
	public final ResponseEntity<ErrorDetails> handleUserNotFoundEntity(Exception ex,WebRequest request){
		ErrorDetails errorDetails=new ErrorDetails(LocalDateTime.now(), ex.getMessage(),
				request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.NOT_FOUND);
	}
}
