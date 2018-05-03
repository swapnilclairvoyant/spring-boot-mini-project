package com.clairvoyant.mvc.exception;

import java.util.Date;

import javax.persistence.EntityNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = LogManager.getLogger(CustomizedExceptionHandler.class);
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ServiceResponse> handleAllException(Exception ex, WebRequest wr) {
		logger.error(ex);
		ServiceResponse exceptionResponse = new ServiceResponse(new Date(), ex.getMessage(),
		        wr.getDescription(false));
		return new ResponseEntity<ServiceResponse>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public final ResponseEntity<ServiceResponse> handleUserNotFound(EntityNotFoundException une, WebRequest wr) {
		logger.error("-----"+une.getMessage());
		ServiceResponse exceptionResponse = new ServiceResponse(new Date(), "User Not Found",
		        wr.getDescription(false));
		return new ResponseEntity<ServiceResponse>(exceptionResponse,HttpStatus.NOT_FOUND);
	}
	
}
