package com.neu.project.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.project.DAO.UserDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Seller;
import com.neu.project.pojo.User;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("loginValidator")
	LoginValidator validator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}

	@RequestMapping(value="/login.htm",method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("user") User user, HttpSession session, Model model, HttpServletRequest request, BindingResult result) throws Exception {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "login";
		}
		

		try {
			System.out.print("test");
			UserDAO userDao = new UserDAO();
			
			User returnedUser;
			System.out.print("test1");
			
			returnedUser = checkCookie(request);
			
			
			
			
			returnedUser = userDao.get(user.getUserId(), user.getPassword());	
			
			if(returnedUser == null) {
//				result.rejectValue("userId", "invalid user");
				model.addAttribute("loginError", "Error while login. Please check the credentials!");				
				return "login";
			}
			else
			{
				System.out.print("success");
				
				
				if(returnedUser.getUserType().equalsIgnoreCase("B"))
				{	
					Seller seller = (Seller)returnedUser;
					session.setAttribute("loggedInUser", seller);
					return "buyerlogin";
				}
				else if (returnedUser.getUserType().equalsIgnoreCase("A")) {
					Seller seller = (Seller)returnedUser;
					session.setAttribute("loggedInUser", seller);
					return "agentlogin";
				}
				else {
					session.setAttribute("loggedInUser", returnedUser);
					return "adminlogin";
				}

			}
			
			
			// DAO.close();
		} catch (AdException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		return "login";
	}
	
	@RequestMapping(value="/login.htm",method = RequestMethod.GET)
	public String initializeForm(@ModelAttribute("user") User user, BindingResult result) {
		return "login";
	}
	

	@RequestMapping(value="/logout.htm",method = RequestMethod.GET)
	public String LogOutForm(@ModelAttribute("user") User user,HttpSession session) {
		session.invalidate();
		return "login";
	}
	
	
	public User checkCookie (HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		User user = null;
		UserDAO userDAO = new UserDAO();
		String username = "";
		String password = "";
		for(Cookie ck : cookies) {
			if(ck.getName().equalsIgnoreCase("userId"))
				username = ck.getValue();
			
			if(ck.getName().equalsIgnoreCase("password"))
				password = ck.getValue();
		}
		if(!username.isEmpty() && !password.isEmpty())
			try {
				user = userDAO.get(username, password);
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		
		return user;
			
		}
		
		
	
}
