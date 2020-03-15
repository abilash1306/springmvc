package com.virtusa.interceptor;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object object) throws IOException {
		
		Calendar cal = Calendar.getInstance();
		
		int day = cal.get(cal.DAY_OF_WEEK);
		
		if(day == 1) {
			response.getWriter().write("The aplication does not run on sunday.Please Try it on any other week day");
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request,HttpServletResponse response,Object object,ModelAndView model) throws Exception{
		System.out.println("PostHandler is called "+request.getRequestURI().toString());
	}
	
	@Override 
	public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object object,Exception exception) throws Exception{
	   System.out.println("After Handler is called "+request.getRequestURI().toString());
	}

}
