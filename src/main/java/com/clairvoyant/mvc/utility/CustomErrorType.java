package com.clairvoyant.mvc.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomErrorType extends RuntimeException	{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomErrorType(String errorMessage) {
		super(errorMessage);
	}
	
	
}
