package com.usa.fedral.gov.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "SSN_MASTER")
public class SsnMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SSN_SEQUENCE_GENERATOR")
	@SequenceGenerator(sequenceName = "ssn_sequence", initialValue = 555544449, allocationSize = 1, name = "SSN_SEQUENCE_GENERATOR")
	@Column(name = "SSN")
	private Long ssn;
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "DOB")
	private Date dob;
	@Column(name = "PHNO")
	private String phno;
	@Column(name = "STATE")
	private String state;
	@Column(name = "PHOTO")
	@Lob
	private byte[] photo;
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	private Date createDate;
	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name="UPDATE_DATE")
	private Date updateDate;
	@Column(name="CREATE_BY")
	private String createdBy;
	@Column(name="UPDATE_BY")
	private String updatedBy;
	
}