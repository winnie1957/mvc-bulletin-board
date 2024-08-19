package com.mvc.homework.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.mvc.homework.model.AnnouncementEntity;

@Repository
public interface AnnouncementDao {
	
	Optional<AnnouncementEntity> findById(Long id);
	List<AnnouncementEntity> findAll();
	Object save(AnnouncementEntity entity);
	void update(AnnouncementEntity entity);
	void delete(Long id);
	    
}
