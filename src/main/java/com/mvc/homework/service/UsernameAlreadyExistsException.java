package com.mvc.homework.service;

public class UsernameAlreadyExistsException extends RuntimeException {
	
	public UsernameAlreadyExistsException(String message) {
        super(message);
    }
	
}
