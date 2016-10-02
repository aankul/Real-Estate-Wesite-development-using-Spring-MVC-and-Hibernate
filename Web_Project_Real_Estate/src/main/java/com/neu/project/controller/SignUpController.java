package com.neu.project.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.project.DAO.UserDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.User;

@Controller
@RequestMapping("/signup.htm")
public class SignUpController {
	@Autowired
	@Qualifier("userValidator")
	UserValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, BindingResult result) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "signup";
		}

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			
			System.out.print("test1");
			
			userDao.create(user.getUserId(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getPhone(), user.getDob(), user.getStreet(), user.getCity(), user.getState(),user.getZip(),user.getUserType());	
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "login";
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {
		return "signup";
	}

}
