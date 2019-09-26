package com.usa.fedral.gov.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usa.fedral.gov.model.SsnModel;

@Service
public interface SsaAppService {

	public Long saveSsnEnrollment(SsnModel ssnmodel);

	List<SsnModel> retrieveAllSsnDetails();
	
	List<SsnModel> retrieveAllSsn(int pageNumber, int pageSize);
	
	public List<String> retrieveAllStates();
	
	public String findStateBySsn(Long ssn);


}
