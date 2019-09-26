package com.usa.fedral.gov.exceptions;

import java.util.Date;

import lombok.Data;
@Data
public class ApiError {

	
	public ApiError(Integer errorCode, String errorDesc, Date date) {
		super();
		this.errorCode = errorCode;
		this.errorDesc = errorDesc;
		this.date = date;
	}
	private Integer errorCode;
	private String errorDesc;
	private Date date;

}
