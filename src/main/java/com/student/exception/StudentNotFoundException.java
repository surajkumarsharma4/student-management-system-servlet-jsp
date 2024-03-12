package com.student.exception;

public class StudentNotFoundException extends RuntimeException{
	
	private String message;

	public StudentNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	
	
}
