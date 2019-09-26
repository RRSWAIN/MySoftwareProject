package com.usa.ng.gov.uhip.admin.service;

import org.springframework.stereotype.Service;

import com.usa.ng.gov.uhip.admin.model.UserAccountModel;

@Service
public interface UserAccountService {

	Boolean createUserAccount(UserAccountModel useraccmodel);

	public String findByEmail(String emailId);

}
