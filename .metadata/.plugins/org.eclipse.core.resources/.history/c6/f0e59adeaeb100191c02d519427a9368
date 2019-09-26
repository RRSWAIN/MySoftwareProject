package com.usa.ng.gov.uhip.admin.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_ACCOUNTS")
public class UserAccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_SEQUENCE_GENERATOR")
	@SequenceGenerator(sequenceName = "user_sequence", initialValue = 1, allocationSize = 1, name = "USER_SEQUENCE_GENERATOR")
	@Column(name = "USER_ID")
	private Integer userAcountId;

	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "DOB")
	private Date dob;

	@Column(name = "SSN")
	private Long ssn;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ROLE")
	private String role;
  
	@Column(name="ACTIVE_SW")
	private String activeSwitch;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Column(name = "CREATE_BY")
	private String createdBy;
	
	@Column(name = "UPDATE_BY")
	private String updatedBy;

}
