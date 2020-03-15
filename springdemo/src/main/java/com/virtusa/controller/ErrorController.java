package com.virtusa.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

	@RequestMapping(value="errors",method=RequestMethod.GET)
	public ModelAndView rendorErrorPage(HttpServletRequest request) {
		System.out.println("Called");
		ModelAndView m = new ModelAndView("errorPage");
		String errorMsg = "";
		int httpErrorCode = (int)request.getAttribute("javax.servlet.error.status_code");
		switch(httpErrorCode){
		case 400:
			errorMsg = "Bad Request";
			break;
		case 401:
			 errorMsg = "Unauthorized";
			 break;
		case 404:
			  errorMsg="Resource not found";
			  break;
		case 500:
			errorMsg="Internal Server Error";
			break;
		}
		m.addObject("errorMsg", errorMsg);
		return m;
	}
}
