package com.virtusa.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.model.User;
import com.virtusa.propertyEditor.StudentNameEditor;

@Controller
public class HomeController {

	@InitBinder
	public void init(WebDataBinder binder) {
		SimpleDateFormat s = new SimpleDateFormat("dd**mm**yyyy");
		binder.registerCustomEditor(Date.class,"studentDOB", new CustomDateEditor(s,false));
		binder.registerCustomEditor(String.class, "studentName", new StudentNameEditor());
	}	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView home() {
//		if(1 == 1)
//	     	throw new NullPointerException();
		
		ModelAndView m = new ModelAndView("admission");
		m.addObject("user", new User());
		return m;
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public ModelAndView add(@Valid @ModelAttribute("user") User user,BindingResult result) {
		
		if(result.hasErrors()){
			ModelAndView m = new ModelAndView("admission");
			return m;
		}
		ModelAndView m = new ModelAndView("success");
		
		System.out.println(user);
		return m;
	}

	
}
