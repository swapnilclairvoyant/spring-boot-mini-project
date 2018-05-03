package com.clairvoyant.mvc.utility;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomErrorType extends RuntimeException	{

	public CustomErrorType(String errorMessage) {
		super(errorMessage);
	}
	
	
}
