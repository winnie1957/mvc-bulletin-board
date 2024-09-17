package com.mvc.homework.service;

import java.sql.SQLIntegrityConstraintViolationException;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mvc.homework.dao.UserDao;
import com.mvc.homework.model.LoginPojo;
import com.mvc.homework.model.RegisterPojo;
import com.mvc.homework.model.RoleEnum;
import com.mvc.homework.model.UserDto;
import com.mvc.homework.model.UserEntity;
import com.mvc.homework.util.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService {
	private final UserDao userDao;
	private final PasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(
		UserDao userDao,
		PasswordEncoder passwordEncoder
	) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public UserDto authenticate(LoginPojo loginUser) throws FailedLoginException, AccountNotFoundException{
		UserEntity entity = userDao.findByUsername(loginUser.getUsername())
			.orElseThrow(() -> new AccountNotFoundException(String.format(
				"Not found User(%s)", 
				loginUser.getUsername())));

		if(passwordEncoder.matches(loginUser.getPassword(), entity.getPassword())) {
	        return convertEntityToDto(entity);
	    }else {
	    	throw new FailedLoginException(String.format("User(%s) Login Failed", loginUser.getUsername()));
		}	    	
	    
	}

	@Override
	public void register(RegisterPojo registerUser) {
		UserEntity entity = new UserEntity(
				registerUser.getUsername(), 
				passwordEncoder.encode(registerUser.getPassword()),
				RoleEnum.MEMBER);
		userDao.save(entity);
	}
	
	private UserDto convertEntityToDto(UserEntity entity) {
		
		return new UserDto(
				entity.getNickname(),
				entity.getUsername(),
				RoleEnum.MEMBER);
	}
	

}
