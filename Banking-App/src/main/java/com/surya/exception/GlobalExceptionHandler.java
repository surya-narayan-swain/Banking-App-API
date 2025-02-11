package com.surya.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	//handle specific exception -Account Exception
	@ExceptionHandler(AccountException.class)
	public ResponseEntity<ErrorDetails> handleAccountException(AccountException exception,
			WebRequest request)
	{
		ErrorDetails details= new ErrorDetails(LocalDateTime.now(), 
				exception.getMessage(), 
			           request.getDescription(false),
			           "Account_Not_Found"
			        	   );
		return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
	}
	
	//handle Generic exception -Account Exception
		@ExceptionHandler(Exception.class)
		public ResponseEntity<ErrorDetails> handleGenericException(Exception exception,
				WebRequest request)
		{
			ErrorDetails details= new ErrorDetails(LocalDateTime.now(), 
					exception.getMessage(), 
				           request.getDescription(false),
				           "Account_Not_Found"
				        	   );
			return new ResponseEntity<>(details,HttpStatus.NOT_FOUND);
		}
	
	
	
}
