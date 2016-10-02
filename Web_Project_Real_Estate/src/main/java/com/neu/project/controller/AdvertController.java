package com.neu.project.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.DAO.FeatureDAO;
import com.neu.project.DAO.PropertyDAO;
import com.neu.project.DAO.UserDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Features;
import com.neu.project.pojo.Property;
import com.neu.project.pojo.Seller;
import com.neu.project.pojo.User;

@Controller
public class AdvertController {
	
	@Autowired
	@Qualifier("advertValidator")
	AdvertValidator advertValidator;
	

	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		System.out.println("post0000000");
		binder.setValidator(advertValidator);
		System.out.println("post0");
	}

	
	@RequestMapping(value = "/postAdvert.htm", method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("property")Property property,HttpSession session, HttpServletRequest request , BindingResult result) throws Exception{
		System.out.println("post1");	
		advertValidator.validate(property, result);
		if(result.hasErrors())
		{
			return "postAdvert";
		}

		Set<Features> featureList = new HashSet<Features>(0);
        String apt = property.getApt();
        String street = property.getStreet();
        String city = property.getCity();
        String state = property.getState();
        String zip = property.getZip();
        int rent = property.getRent();
        int area = property.getArea();
        int bhk = property.getBhk();
        String photoName = property.getPhotoName();
        
        String[] featureDesc = property.getFeature_name();
//        String[] featList = request.getParameterValues("features");

        try {

        		
        		System.out.println("propertyDAOb4");
        		PropertyDAO propertydao = new PropertyDAO();
        		FeatureDAO featureDAO = new FeatureDAO();
        		for(int i=0;i<featureDesc.length;i++) {
        			Features feature = featureDAO.get(featureDesc[i]);
        			featureList.add(feature);
        		}
        		Seller seller = (Seller) session.getAttribute("loggedInUser");
//        		seller.addProperty(property);
        		propertydao.create(apt, street, city, state, zip, photoName, seller, featureList, rent, bhk, area);
        		
        		
        		

        		
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        return "advertPosted";
    }
	
	

	@RequestMapping(value = "/agentAdvert.htm", method=RequestMethod.GET)
    public String initializeForm(@ModelAttribute("property")Property property, BindingResult result) throws AdException { 
//	    List<Features> FeatureList = null;
//	    System.out.println("hfhdfdjdtjtgdjtgdjtgdj");
/*		FeatureDAO featureDAO = new FeatureDAO();
		FeatureList = featureDAO.list();
        ModelAndView mv = new ModelAndView("postAdvert", "featureList", FeatureList);
        return mv;
*/        
                return "postAdvert";
    } 

/*
	@RequestMapping(value = "/agentAdvert.htm")
    public String postAdvertForm(@ModelAttribute("property")Property property) { 
		System.out.println("get");
        return "postAdvert"; 
    } 	
	
*/

}