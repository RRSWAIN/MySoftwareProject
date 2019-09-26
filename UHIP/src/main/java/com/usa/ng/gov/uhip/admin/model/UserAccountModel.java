package com.usa.ng.gov.uhip.admin.model;

import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
@Configuration
public class UserAccountModel {

	private Integer userAcountId;

	private String firstName;

	private String lastName;
	
	@DateTimeFormat(pattern = "dd/mm/yy")
	private Date dob;

	private String email;

	private String gender;

	private Long ssn;

	private String password;

	private String role;

	private String activeSwitch;

	@DateTimeFormat(pattern = "dd/mm/yy")
	private Date createDate;
	@DateTimeFormat(pattern = "dd/mm/yy")
	private Date updateDate;
	private String createdBy;
	private String updatedBy;

}
