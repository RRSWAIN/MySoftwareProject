package com.usa.fedral.gov.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usa.fedral.gov.service.SsaAppService;

@RestController
public class SsnRestController {
	@Autowired
	SsaAppService SsAppserviceImpl;

	@RequestMapping(value = "/getstatename", produces = { "application/json" ,"text/plain"}, method = RequestMethod.GET)
	public String getStateBySsn(@RequestParam("ssn") String ssn)
	
	{
		try {
		return SsAppserviceImpl.findStateBySsn(Long.parseLong(ssn));
		}
		 
		catch (NumberFormatException e) {
		    throw new NumberFormatException("please enterd valid SSN  , " + ssn+"");
		 }
	}

}

