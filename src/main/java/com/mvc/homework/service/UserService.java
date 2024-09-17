package com.mvc.homework.service;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;

import com.mvc.homework.model.LoginPojo;
import com.mvc.homework.model.RegisterPojo;
import com.mvc.homework.model.UserDto;

public interface UserService {

	UserDto authenticate(LoginPojo loginUser) throws FailedLoginException, AccountNotFoundException;
	
	void register(RegisterPojo registerUser);
	
}
