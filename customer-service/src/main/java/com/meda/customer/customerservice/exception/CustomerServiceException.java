package com.meda.customer.customerservice.exception;


public class CustomerServiceException extends  Exception{
	
	public CustomerServiceException() {
	}


	
	public CustomerServiceException(String message, Throwable cause) {
	super(message, cause);
	
	}
	
	public CustomerServiceException(final String message) {
	super(message);
	// TODO Auto-generated constructor stub
	}
	
	public CustomerServiceException(Throwable cause) {
	super(cause);
	// TODO Auto-generated constructor stub
	}



}
