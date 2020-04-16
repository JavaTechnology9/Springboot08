package com.javatechnology.exception;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
@Component
public class MyErrorViewResolver implements ErrorViewResolver{

	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
		Integer errorStatus=(Integer)model.get("status");
		String path=(String)model.get("path");
		ModelAndView view=new ModelAndView("errorPage");
		String errorinfo=(String)model.get("error");
		String errorresult=errorStatus+"::"+path+"::"+errorinfo;
		view.addObject("ErrorInfo", errorresult);
		return view;
	}

}
