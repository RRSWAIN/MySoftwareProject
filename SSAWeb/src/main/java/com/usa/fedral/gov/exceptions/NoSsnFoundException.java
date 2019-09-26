package com.usa.fedral.gov.exceptions;

public class NoSsnFoundException extends RuntimeException {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6083922931304850744L;

	
	public NoSsnFoundException() {
	}


	public NoSsnFoundException(String msg){
		
		super(msg);
		
	}
}
