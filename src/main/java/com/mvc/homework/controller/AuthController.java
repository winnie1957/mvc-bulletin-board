package com.mvc.homework.controller;

import javax.security.auth.login.AccountNotFoundException;
import javax.security.auth.login.FailedLoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.homework.model.LoginPojo;
import com.mvc.homework.model.RegisterPojo;
import com.mvc.homework.service.UserService;
import com.mvc.homework.service.UsernameAlreadyExistsException;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {
	
	private final UserService userService;
	
	@Autowired
	public AuthController(
		UserService userService
	) {
		this.userService = userService;
	}

	@RequestMapping(method = RequestMethod.GET, value="/login")
	public ModelAndView loginForm(){

		return new ModelAndView("loginForm");
	}

	@RequestMapping(method = RequestMethod.POST, value="/login")
	public ModelAndView login(
		@ModelAttribute(name = "user") LoginPojo user,
		HttpSession session
	){
		String result = "redirect:/";
		try {
			userService.authenticate(user);
		} catch (AccountNotFoundException e) {
			result = "redirect:/auth/login?notfound";
		} catch (FailedLoginException e) {
			result = "redirect:/auth/login?failed";
		}
		session.setAttribute("user", user);
		return new ModelAndView(result);
	}

	@RequestMapping(method = RequestMethod.GET, value="/logout")
	public ModelAndView logout(
		HttpServletRequest request,
		HttpServletResponse response
	){
		request.getSession().invalidate();
		
		return new ModelAndView("redirect:/auth/login");
	}

	@RequestMapping(method = RequestMethod.GET, value="/register")
	public ModelAndView registerForm(){
		
		return new ModelAndView("registerForm");
	}
    
	@RequestMapping(method = RequestMethod.POST, value="/register")
	public ModelAndView register(
		@ModelAttribute(name = "user") RegisterPojo user
	){
		userService.register(user);

		return new ModelAndView("redirect:/auth/login");
	}

    

}
