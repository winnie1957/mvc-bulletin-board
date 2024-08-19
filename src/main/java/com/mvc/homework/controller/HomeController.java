package com.mvc.homework.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.homework.model.AnnouncementDto;
import com.mvc.homework.service.AnnouncementService;

@Controller
public class HomeController {
	private final AnnouncementService announcementService;
	
	@Autowired
	public HomeController(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

	@RequestMapping(value="/")
	public ModelAndView home(HttpServletResponse response) throws IOException{
		List<AnnouncementDto> announcements = announcementService.getAllAnnouncements();
		
		return new ModelAndView("home", "announcements", announcements);
	}
	
}
