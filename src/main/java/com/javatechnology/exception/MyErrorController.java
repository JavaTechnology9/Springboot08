package com.javatechnology.exception;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//@Controller
public class MyErrorController /* implements ErrorController */{

	/*@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return "/";
	}
	@RequestMapping("/error")
	public String getErrorPage(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if(status!=null) {
			int errorCode=Integer.valueOf(status.toString());
			if(errorCode==HttpStatus.NOT_FOUND.value()) {
				return "error-404";
			}else if(errorCode==HttpStatus.INTERNAL_SERVER_ERROR.value()){
				return "error-500";
			}
		}
		return "errorPage";
		
	}*/

}
