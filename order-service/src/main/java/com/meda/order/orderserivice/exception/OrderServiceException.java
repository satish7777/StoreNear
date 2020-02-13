package com.meda.order.orderserivice.exception;

public class OrderServiceException extends Exception{

	public OrderServiceException() {
			}

	

	public OrderServiceException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public OrderServiceException(final String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public OrderServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
