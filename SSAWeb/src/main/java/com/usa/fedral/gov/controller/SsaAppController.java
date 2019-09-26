package com.usa.fedral.gov.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.usa.fedral.gov.constants.SsaAppConstants;
import com.usa.fedral.gov.exceptions.NoSsnFoundException;
import com.usa.fedral.gov.model.SsnModel;
import com.usa.fedral.gov.properties.SsaAppProperties;
import com.usa.fedral.gov.service.SsaAppService;

@Controller
public class SsaAppController {
	private static final Logger logger = LoggerFactory.getLogger(SsaAppController.class);
	@Autowired
	SsaAppService SsaAppServiceImpl;
	@Autowired
	SsaAppProperties appproperties;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayEnrollForm(Model model) {
		logger.debug("** display EnrollForm started**");
		SsnModel ssnModel = new SsnModel();
		// key=ssnModel, value=ssnModel
		// form is binded to model object
		// here our model class(ssnModel) has form data
		// which added to this model(spring ui)

		/*
		 * //creating null pointer Exception String name=null; name.charAt(0);
		 */
		/*
		 * int num=10/0;
		 */ formValues(model);

		model.addAttribute(SsaAppConstants.SSN_MOD_EL, ssnModel);
		logger.debug("** display EnrollForm ended with form values**");
		logger.info("**form display with default field**");
		// returning view name as jsp
		return SsaAppConstants.EN_ROLL_SSN;
	}

	// controller level exception handling
	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Model model) {
		// String msg= "Oops,something went wrong!";
		model.addAttribute("errmsg", "Oops,something went wrong!");

		return "error";
	}

	@RequestMapping(value = "/enroll", method = RequestMethod.POST)
	public String saveData(@ModelAttribute(SsaAppConstants.SSN_MOD_EL) SsnModel ssnModel, Model model) {

		logger.debug("** saveData() started **");

		// again callling formvalues method to set the grnderData to the model scope
		formValues(model);

		model.addAttribute(SsaAppConstants.SSN_MOD_EL, ssnModel);

		// Retrieving ssn from service
		Long ssn = SsaAppServiceImpl.saveSsnEnrollment(ssnModel);
		logger.debug("** ssn number is generated**");

		// loading the properties value to the controller
		Map<String, String> propsmap = appproperties.getSsaprops();

		// checking ssn is null or not ?
		if (ssn != null && ssn > 0) {
			model.addAttribute("msg", " YOUR SSN IS " + ssn);
			// if not null then show success message
			model.addAttribute(SsaAppConstants.SUC_MSG_KEY, propsmap.get(SsaAppConstants.SUC_MSG));
		} else
			throw new NoSsnFoundException("NO SSN FOUND");
		// if not null then show failure message
		model.addAttribute(SsaAppConstants.SUC_MSG_KEY, propsmap.get(SsaAppConstants.FAIl_MSG));
		logger.info("** saveData() Execution Completed**");

		return SsaAppConstants.EN_ROLL_SSN;
	}

	@RequestMapping(value = "/ssndetailsdispaly", method = RequestMethod.GET)
	public String displaySsnDetails(Model model) {
		logger.debug("** displaySsnDetails() started **");

		List<SsnModel> ssnDetails = SsaAppServiceImpl.retrieveAllSsnDetails();
		logger.debug("** All records retrieved from table**");
		model.addAttribute("ssnDetails", ssnDetails);
		System.out.println(ssnDetails.size());
		logger.info("** displaySsnDetails() Execution Completed**");
		return "ssndetails";
	}

	public void formValues(Model model) {
		List<String> genderlist = new ArrayList<String>();
		genderlist.add("Male");
		genderlist.add("Female");
		model.addAttribute("genders", genderlist);

		List<String> statelist = SsaAppServiceImpl.retrieveAllStates();

		model.addAttribute("statelist", statelist);

	}

}
