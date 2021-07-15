package com.pillowlux.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.pillowlux.exceptions.CustomerNotFoundException;
import com.pillowlux.exceptions.ProductNotFoundException;


@ControllerAdvice
public class AppExceptionHandler {
	
	 @ExceptionHandler(CustomerNotFoundException.class)
	    public ResponseEntity<Object> handleCustomerNotFoundException(
	        CustomerNotFoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", ex.getMessage());

	        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	    }
	 
	 @ExceptionHandler(ProductNotFoundException.class)
	    public ResponseEntity<Object> handleProductNotFoundException(
	        ProductNotFoundException ex, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", LocalDateTime.now());
	        body.put("message", ex.getMessage());

	        return new ResponseEntity<Object>(body, HttpStatus.NOT_FOUND);
	    }
}
