package com.mvc.homework.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.homework.model.AnnouncementDto;
import com.mvc.homework.model.AnnouncementEntity;

@Service
public interface AnnouncementService {

	AnnouncementDto getAnnouncementById(Integer id);
	List<AnnouncementDto> getAllAnnouncements();
	void createAnnouncement(AnnouncementDto dto);
	void updateAnnouncement(AnnouncementDto dto);
	void deleteAnnouncementById(Integer id);
	
	
}
