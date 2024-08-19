package com.mvc.homework.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.homework.dao.AnnouncementDao;
import com.mvc.homework.model.AnnouncementDto;
import com.mvc.homework.model.AnnouncementEntity;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
	
	private final AnnouncementDao announcementdao;

	@Autowired
	public AnnouncementServiceImpl(AnnouncementDao announcementdao){
		this.announcementdao = announcementdao;
	}

	@Override
	public AnnouncementDto getAnnouncementById(Integer id) {
		if(id == null) {
			return new AnnouncementDto();
		}
		Optional<AnnouncementEntity> entity = announcementdao.findById(Long.valueOf(id));
		
		AnnouncementDto dto = new AnnouncementDto();
		if(entity.isPresent()) {
			dto = convertEntityToDto(entity.get());
		}
		
		return dto;
	}
	
	@Override
	public List<AnnouncementDto> getAllAnnouncements() {		
		List<AnnouncementEntity> entities = announcementdao.findAll();
		
		return entities.stream()
			.map(this::convertEntityToDto)
			.collect(Collectors.toList());
	}
	
	@Override
	public void createAnnouncement(AnnouncementDto dto) {
		AnnouncementEntity entity = convertDtoToEntity(dto);
		announcementdao.save(entity);				
	}

	@Override
	public void deleteAnnouncementById(Integer id) {
		announcementdao.delete(Long.valueOf(id));
	}

	@Override
	public void updateAnnouncement(AnnouncementDto dto) {
		AnnouncementEntity entity = convertDtoToEntity(dto);
		announcementdao.update(entity);
		
	}

	private AnnouncementDto convertEntityToDto(AnnouncementEntity entity) {
		return AnnouncementDto.builder()
			.id(entity.getId())
			.title(entity.getTitle())
			.content(entity.getContent())
			.publishBy(entity.getPublishBy())
			.publishDate(entity.getPublishAt())
			.closedDate(entity.getClosedAt())
			.build();
	}
	
	private AnnouncementEntity convertDtoToEntity(AnnouncementDto dto) {
		return new AnnouncementEntity(
			dto.getId(),
			dto.getTitle(),
			dto.getContent(),
			dto.getPublishBy(),
			convertStringToLocalDate(dto.getPublishDate()),
			convertStringToLocalDate(dto.getClosedDate()));
	}
	
	private LocalDate convertStringToLocalDate(String date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    return LocalDate.parse(date, formatter);
	}

}
