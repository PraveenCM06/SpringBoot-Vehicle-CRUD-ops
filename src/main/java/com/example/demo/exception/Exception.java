package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class Exception extends RuntimeException {

	private String resourceName;
	private String fieldName;
	private Object fieldValue;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Exception(String resourceName, String fieldName, Object fieldValue) {
		super(resourceName+" Not found for "+fieldName+": "+fieldValue);
		this.resourceName=resourceName;
		this.fieldName=fieldName;
		this.fieldValue=fieldValue;
	}
}
