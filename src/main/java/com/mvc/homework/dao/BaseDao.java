package com.mvc.homework.dao;

import java.util.List;
import java.util.Optional;

public interface BaseDao<Entity, Id> {

	Optional<Entity> findById(Id id);
	
	List<Entity> findAll();
	
	void save(Entity entity);
	
	void update(Entity entity);
	
	void delete(Id id);
	
}
