package com.clairvoyant.mvc.exception;

import java.util.Date;


public class ServiceResponse<T> {
	  private Date timestamp;
	  private String message;
	  private String details;
	  private boolean isError=true;
	  private T data;
	  
	  public ServiceResponse(Date timestamp, String message, String details) {
		    super();
		    this.timestamp = timestamp;
		    this.message = message;
		    this.details = details;
		  }


	public ServiceResponse(T allUser) {
		super();
		this.isError = false;
		this.data = allUser;
	}


	public boolean isError() {
		return isError;
	}


	public void setError(boolean isError) {
		this.isError = isError;
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}
	  
	  
}
