package com.usa.fedral.gov.model;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
@Configuration
public class SsnModel {
 
	private Long ssn;
	private String firstName;
	private String lastName;
	private String gender;
	@DateTimeFormat(pattern="dd/mm/yy")
	private Date dob;
	private String phno;
	private String state;
	private MultipartFile photo;
	@DateTimeFormat(pattern="dd/mm/yy")
	private Date createDate;
	@DateTimeFormat(pattern="dd/mm/yy")
	private Date updateDate;
	private String createdBy;
	private String updatedBy;
		

}
