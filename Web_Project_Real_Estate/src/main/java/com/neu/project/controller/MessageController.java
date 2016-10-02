package com.neu.project.controller;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import com.neu.project.DAO.MessageDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.User;


@Controller
public class MessageController {
	
	
	@RequestMapping(value="/MessageAgent.htm", method=RequestMethod.POST)
    protected String handleRequestInternal(HttpServletRequest request, HttpSession session) throws Exception {
        	String userTo = request.getParameter("userTo");
        	String message = request.getParameter("messageBox");
        	User user = (User) session.getAttribute("loggedInUser");
        	MessageDAO messageDAO = new MessageDAO();
        	messageDAO.postMessage(userTo, message, user);
        try {
        	
        	
        	
        	
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "success";
    }
	
	@RequestMapping(value="/MessageAgent.htm", method=RequestMethod.GET)
	public ModelAndView MessageAgent(HttpServletRequest request) {
		String userTo = request.getParameter("user");
		ModelAndView mv = new ModelAndView("postMessage","userTo",userTo);
		return mv;
	}
	
	
	@RequestMapping(value="/agentInbox.htm", method=RequestMethod.GET)
	public ModelAndView InboxAgent(HttpServletRequest request) {
		String user = request.getParameter("user");
		MessageDAO messageDAO = new MessageDAO();
		List MessageList = null;
		try {
			MessageList = messageDAO.getInbox(user);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		ModelAndView mv = new ModelAndView("agentInbox","MessageList",MessageList);
		return mv;
	}
	
	
	@RequestMapping(value="/MessageBuyer.htm", method=RequestMethod.GET)
	public ModelAndView MessageBuyer(HttpServletRequest request) {
		String userTo = request.getParameter("user");
		ModelAndView mv = new ModelAndView("postMessage","userTo",userTo);
		return mv;
	}
	
	
	@RequestMapping(value="/buyerInbox.htm", method=RequestMethod.GET)
	public ModelAndView InboxBuyer(HttpServletRequest request) {
		String user = request.getParameter("user");
		MessageDAO messageDAO = new MessageDAO();
		List MessageList = null;
		try {
			MessageList = messageDAO.getInbox(user);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		ModelAndView mv = new ModelAndView("agentInbox","MessageList",MessageList);
		return mv;
	}
	
	@RequestMapping(value="/Addtocart.htm", method=RequestMethod.GET)
	public ModelAndView AddToCart(HttpServletRequest request,HttpSession session) {
		long property = Long.parseLong(request.getParameter("prop"));
		//In Message DAO
		MessageDAO messageDAO = new MessageDAO();
		User user = (User) session.getAttribute("loggedInUser");
		List list = null;
//		Boolean added = false;
		try {
			list = messageDAO.checkCart(String.valueOf(user.getPersonId()));			
			if(!list.contains(property)) {
				messageDAO.AddToCartMethod(property, user);
//				added = true;
			}
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("propAdded");
//		mv.addObject("added", added);
		return mv;
	}	
	
	@RequestMapping(value="/buyersCart.htm", method=RequestMethod.GET)
	public ModelAndView ViewCart(HttpServletRequest request,HttpSession session) {
		String personId = request.getParameter("user");
		//In Message DAO
		MessageDAO messageDAO = new MessageDAO();
		List<Property> list = new ArrayList<Property>();
//		User user = (User) session.getAttribute("loggedInUser");
		
		try {
			list = messageDAO.getCart(personId);
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ModelAndView mv = new ModelAndView("myPropertyList","propList",list);
		return mv;
	}
}	
	