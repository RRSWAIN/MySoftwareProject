package com.usa.fedral.gov.exceptions;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Model model) {
		//String msg= "Oops,something went wrong!";
		model.addAttribute("errmsg","Oops,something went wrong!");
		
		return "error";
	}

	@ExceptionHandler(value =ArithmeticException.class)
	public String handleAirithmaticException(Model model) {
		//String msg= "Oops,something went wrong!";
		model.addAttribute("msg","Oops,some problem in calculation");
		
		return "error";
	}
	@ExceptionHandler(value=NoSsnFoundException.class)
	public String handlessnNotFoundException(Model model) {
		
		
		model.addAttribute("staterror", "ssn is not registerd");
		return "customError";
	}
	
	
}
