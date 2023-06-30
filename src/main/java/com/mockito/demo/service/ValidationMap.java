package com.mockito.demo.service;

public class ValidationMap {
	String fieldName;
	String fieldError;
	
	
	public ValidationMap(String fieldName, String fieldError) {
		super();
		this.fieldName = fieldName;
		this.fieldError = fieldError;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	public String getFieldError() {
		return fieldError;
	}
	public void setFieldError(String fieldError) {
		this.fieldError = fieldError;
	}
	
}
