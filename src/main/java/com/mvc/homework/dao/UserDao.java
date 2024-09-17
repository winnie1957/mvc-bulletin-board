package com.mvc.homework.dao;

import java.util.List;
import java.util.Optional;

import com.mvc.homework.model.UserEntity;

public interface UserDao {

	Optional<UserEntity> findById(Long id);
	Optional<UserEntity> findByUsername(String username);
	List<UserEntity> findAll();
	void save(UserEntity entity);
	void delete(Long id);
	
}
