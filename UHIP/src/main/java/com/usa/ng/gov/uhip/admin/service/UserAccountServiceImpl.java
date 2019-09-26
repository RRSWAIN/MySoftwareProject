package com.usa.ng.gov.uhip.admin.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usa.ng.gov.uhip.admin.entity.UserAccountEntity;
import com.usa.ng.gov.uhip.admin.model.UserAccountModel;
import com.usa.ng.gov.uhip.admin.repository.UserAccountRepository;
@Service
public class UserAccountServiceImpl implements UserAccountService {

	@Autowired
	UserAccountRepository useraccrepo;

	@Override
	public Boolean createUserAccount(UserAccountModel useraccmodel) {

		UserAccountEntity accountEntity = new UserAccountEntity();

		BeanUtils.copyProperties(useraccmodel, accountEntity);
		accountEntity.setActiveSwitch("Y");

		UserAccountEntity entities = useraccrepo.save(accountEntity);
		
		Boolean isSaved=false;
		
		if(isSaved==true) {
		
			entities.getUserAcountId();
		
			return isSaved;
		}
		
      return isSaved;
	}

	@Override
	public String findByEmail(String emailId) {

		UserAccountEntity entity = useraccrepo.findByEmail(emailId);		
	
		return (entity == null)? "Unique" : "Duplicate";
	}
}
