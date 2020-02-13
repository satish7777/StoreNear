package com.meda.user.userservice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpStatus;


@ControllerAdvice
public class UserServiceErrorAdvice {
	
	@ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
        return error(INTERNAL_SERVER_ERROR, e);
    }
    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<String> handleNotFoundException(UserNotFoundException e) {
        return error(NOT_FOUND, e);
    }
    
	/*
	 * @ExceptionHandler({Exception.class}) public ResponseEntity<String>
	 * handleException(String message,Exception e){ return
	 * error(INTERNAL_SERVER_ERROR, message ,e); }
	 */
    
    @ExceptionHandler({UserServiceException.class,Exception.class})
    public ResponseEntity<String> handleUserServiceException(UserServiceException e){
        return error(INTERNAL_SERVER_ERROR, e);
    }
    
    
	/*
	 * private ResponseEntity<String> error(HttpStatus status,String message,
	 * Exception e) {
	 * 
	 * return ResponseEntity.status(status).body(message +":" + e.getMessage()); }
	 */

    
 private ResponseEntity<String> error(HttpStatus status, Exception e) {
        
        return ResponseEntity.status(status).body(e.getMessage());
    }
}
