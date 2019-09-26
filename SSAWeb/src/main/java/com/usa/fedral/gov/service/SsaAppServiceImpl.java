
package com.usa.fedral.gov.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.usa.fedral.gov.entity.SsnMaster;
import com.usa.fedral.gov.entity.StatesMaster;
import com.usa.fedral.gov.exceptions.NoStateFoundException;
import com.usa.fedral.gov.model.SsnModel;
import com.usa.fedral.gov.model.StatesModel;
import com.usa.fedral.gov.repository.SsnMasterRepository;
import com.usa.fedral.gov.repository.StatesMasterRepository;

@Service
public class SsaAppServiceImpl implements SsaAppService {
	private static final Logger lOGGER = LoggerFactory.getLogger(SsaAppServiceImpl.class);
	@Autowired
	SsnMasterRepository ssnmasterrepository;
	@Autowired
	StatesMasterRepository statesmasterrepo;

	@Override
	public Long saveSsnEnrollment(SsnModel ssnmodel) {
		lOGGER.debug("**sav" + "eSsnEnrollment started **");
		// creating entity class object to store model data to entity Object
		// model has form data binded with it
		SsnMaster ssnMaster = new SsnMaster();

		// System.out.println(ssnMaster.getPhoto().getSize());
		// System.out.println(ssnMaster.getPhoto().getOriginalFilename());

		// copy the model class object to entity class object
		// As repository only want entity object
		BeanUtils.copyProperties(ssnmodel, ssnMaster);

		MultipartFile file = ssnmodel.getPhoto();
		byte[] byteArr = null;

		try {
			byteArr = file.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		ssnMaster.setPhoto(byteArr);

		// Collecting entity object with primary key
		ssnMaster = ssnmasterrepository.save(ssnMaster);
		lOGGER.debug("**sending entity data to repository **");
		// Long ssn = Long.parseLong(master.toString());

		lOGGER.info("**saveSsnEnrollment() completed**");
		// returning ssn from entity class
		return ssnMaster.getSsn();

	}

	@Override
	public List<SsnModel> retrieveAllSsn(int pageNumber, int pageSize) {
		System.out.println("THis method is for PAGINATION");
		return null;
	}

	// this method is used to retrieve all the record from
	@Override
	public List<SsnModel> retrieveAllSsnDetails() {

		List<SsnModel> models = new ArrayList<SsnModel>();

		List<SsnMaster> entities = ssnmasterrepository.findAll();

		if (entities.isEmpty()) {
			System.out.println("No entities avilable");
		}
		// convert entities to model
		else {
			// iterating as collection is not empty
			for (SsnMaster entity : entities) {
				SsnModel model = new SsnModel();

				// every entity object is copying to model
				BeanUtils.copyProperties(entity, model);

				// adding the model into collection
				models.add(model);
			}
		}
		// finnally returning model collection
		return models;
	}

	public List<String> retrieveAllStates() {
		
		List<String> models = new ArrayList<String>();
		List<StatesMaster> entities = statesmasterrepo.findAll();
		if (entities.isEmpty()) {
			System.out.println("No entities avilable");
		}
		// convert entities to model
		else {
			// iterating as collection is not empty
			for (StatesMaster entity : entities) {
				StatesModel model = new StatesModel();
				// every entity object im copying to model
				BeanUtils.copyProperties(entity, model);
				// adding the model into collection
				models.add(model.getStateName());
			}
		}
		lOGGER.info("**retrieveAllStates() completed**");
		return models;
	}

	@Override
	public String findStateBySsn(Long ssn) {
		Optional<SsnMaster> entity = ssnmasterrepository.findById(ssn);
		String stateName = null;
		if (entity.isPresent())
			stateName = entity.get().getState();
		else
			throw new NoStateFoundException("Incorrect SSN");

		return stateName;
	}

}