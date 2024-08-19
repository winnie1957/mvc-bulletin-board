package com.mvc.homework.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.homework.model.AnnouncementDto;
import com.mvc.homework.service.AnnouncementService;

@Controller
@RequestMapping(value = "/announcement")
public class AnnouncementController {
	
	private final AnnouncementService announcementService;
	
	@Autowired
	public AnnouncementController(AnnouncementService announcementService) {
		this.announcementService = announcementService;
	}

//	@GetMapping(value="/test")
//	public ResponseEntity<String> test(HttpServletResponse response) throws IOException{
//		
//		List<AnnouncementDto> announcements = announcementService.getAllAnnouncements();
//		System.out.println(announcements);
//		
//		return ResponseEntity.ok("User created successfully.");
//	}
	
	@RequestMapping(value="/")
	public ModelAndView list(HttpServletResponse response) {
		List<AnnouncementDto> announcements = announcementService.getAllAnnouncements();
		return new ModelAndView("announcements", "announcements", announcements);
	}

	@RequestMapping(method = RequestMethod.GET, value="/edit/{id}")
    public ModelAndView edit(
		@PathVariable("id") Integer id, 
		Model model
    ) {
    	AnnouncementDto announcement = announcementService.getAnnouncementById(id);
        model.addAttribute("announcement", announcement);
		return new ModelAndView("announcementForm");
    }

	@RequestMapping(method = RequestMethod.POST, value="/save")
    public ModelAndView save(
    	@ModelAttribute(name = "announcement") AnnouncementDto announcement
    ) {
    	if(announcement.getId() == null) {
    		announcementService.createAnnouncement(announcement);
    	}else {
    		announcementService.updateAnnouncement(announcement);
    	}

		return new ModelAndView("redirect:/announcement/");
    }

	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
    public ModelAndView delete(
    	@PathVariable("id") Integer id
    ) {
    	announcementService.deleteAnnouncementById(id);
		return new ModelAndView("redirect:/");
    }
    
    

}
