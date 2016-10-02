package com.neu.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.neu.project.DAO.FeatureDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Features;


@Controller
public class AdminController {
	
	@Autowired
	@Qualifier("featureValidator")
	FeatureValidator featureValidator;
	
    
	@InitBinder
	private void initBinder(WebDataBinder binder)
	{
		binder.setValidator(featureValidator);
	}
	
	
	@RequestMapping(value = "/addFeatures.htm", method=RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("feature")Features feature,BindingResult result) throws Exception
    {
		featureValidator.validate(feature, result);
		if(result.hasErrors())
		{
			return "addFeatureForm";
		}
        
        try
        {
        	FeatureDAO featureDAO = new FeatureDAO();
        	featureDAO.create(feature.getFeatureDesc());
            //DAO.close();
        }
        catch (AdException e)
        {
            System.out.println(e.getMessage());
        }
        return "success";
    }
    
	
	@RequestMapping(value = "/addFeatures.htm", method=RequestMethod.GET)
    public String postAdvertForm(@ModelAttribute("features")Features features, BindingResult result) { 
		System.out.println("get");
        return "addFeatureForm"; 
    } 

}
