package com.usa.ng.gov.uhip.admin.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.usa.ng.gov.uhip.admin.model.UserAccountModel;
import com.usa.ng.gov.uhip.admin.service.UserAccountService;
import com.usa.ng.gov.uhip.util.UhipAppProperties;

@Controller
public class UserAccountController {

	@Autowired
	UserAccountService userservice;
	@Autowired
	UhipAppProperties uhipapppropties;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayCreatesUserForm(Model model) {
		UserformLoad(model);

		UserAccountModel accountModel = new UserAccountModel();
		model.addAttribute("accountModel", accountModel);
		return "userregistation";
	}

	@RequestMapping(value = "/registeruser", method = RequestMethod.POST)
	public String saveFormData(@ModelAttribute("accountModel") UserAccountModel accountModel, Model model,
			RedirectAttributes riderect) {

		UserformLoad(model);
		riderect.addFlashAttribute("accountModel", accountModel);

		Boolean isSaved = userservice.createUserAccount(accountModel);
		riderect.addFlashAttribute("accountModel", accountModel);

		return "redirect:/user-registation-success";
	}

	@RequestMapping(value = "user-registation-success", method = RequestMethod.GET)
	public String UserRegistrationDone(@ModelAttribute("accountModel") UserAccountModel accountModel, Model model) {
		UserformLoad(model);
		System.out.println("uuser acoubt model" + accountModel);
		return "userregistation";
	}
	
	@RequestMapping(value="/validateEmail")
	public @ResponseBody String checkEmailvalidity(HttpServletRequest req, Model model) {
		
		String emailId = req.getParameter("email");
		
		return userservice.findByEmail(emailId);
	}

	public void UserformLoad(Model model) {
		List<String> genderlist = new ArrayList<String>();
		genderlist.add("Male");
		genderlist.add("Female");
		model.addAttribute("genders", genderlist);

		List<String> rolelist = new ArrayList<String>();
		rolelist.add("Caseworker");
		rolelist.add("Admin");
		model.addAttribute("rolelist", rolelist);

	}

}
