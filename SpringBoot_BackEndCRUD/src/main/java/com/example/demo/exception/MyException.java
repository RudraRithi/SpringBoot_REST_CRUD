package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MyException extends RuntimeException {
	
	private static final long seriaLVersionUID = 1L;
	private String resourcName;
	private String fieldName;
	private long fieldValue;
	
	public MyException(String resourcName, String fieldName, long id) {
		super( String.format("%s not found with %s : '%s' ", resourcName, fieldName, id));
		this.resourcName = resourcName;
		this.fieldName = fieldName;
		this.fieldValue = id;
	}

	public String getResourcName() {
		return resourcName;
	}

	

	public String getFieldName() {
		return fieldName;
	}

	

	public long getFieldValue() {
		return fieldValue;
	}

	
	
}
