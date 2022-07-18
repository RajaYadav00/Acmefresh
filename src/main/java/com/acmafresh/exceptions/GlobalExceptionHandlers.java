package com.acmafresh.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;



@ControllerAdvice
public class GlobalExceptionHandlers {
	
	@ExceptionHandler(ClientsException.class)
	public ResponseEntity<MyErrorDetails> handleClientsException(ClientsException exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ConsumersException.class)
	public ResponseEntity<MyErrorDetails> handleConsumersException(ConsumersException exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<MyErrorDetails> handleAdminException(AdminException exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(LoginException.class)
	public ResponseEntity<MyErrorDetails> handleLoginException(LoginException exp, WebRequest req) {

		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), exp.getMessage(), req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> myExpHandlerMain(Exception ie, WebRequest wr) {
		System.out.println("inside myHandler method...EXP");
		MyErrorDetails err = new MyErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}
}
