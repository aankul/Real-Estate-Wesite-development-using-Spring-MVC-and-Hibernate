package com.neu.project.controller;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.neu.project.DAO.FeatureDAO;
import com.neu.project.DAO.PropertyDAO;
import com.neu.project.DAO.SearchDAO;
import com.neu.project.exception.AdException;
import com.neu.project.pojo.Features;
import com.neu.project.pojo.Property;

@Controller
public class SearchController {
	
	@RequestMapping(value="/search.htm",method=RequestMethod.GET)
    public String postAdvertForm() { 
		System.out.println("get");
        return "searchApt"; 
    }
	
	@RequestMapping(value="/search.htm",method=RequestMethod.POST)
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
		
        List propList = new ArrayList();
        Set<String> hashsetList = null;
        List<String> list = null;
/*        int page;
        if( request.getParameter("page") == null) {
        	page=1;
        }
        else
        {
        	page = Integer.parseInt(request.getParameter("page"));
        }
*/        
 //       int pageNum = Integer.parseInt(request.getParameter("page"));
        try {
        	System.out.println("inside bro");
        	String searchText = request.getParameter("searchText");
//        	NewSearch ns = new NewSearch();
//        	propList = ns.searchForProperty(searchText);
        	
        	SearchDAO searchDAO = new SearchDAO();
        	FeatureDAO featureDAO = new FeatureDAO();
        	String filterBy = request.getParameter("filterBy");
        	int bhk = Integer.parseInt(request.getParameter("BHK"));
        	int rent = Integer.parseInt(request.getParameter("Rent"));
        	int area = Integer.parseInt(request.getParameter("Area"));
        	String[] featArray = request.getParameterValues("feat");        	
        	List<String> featureList = new ArrayList<String>();
        	
        	if(featArray != null)
        	{
        		for(int i=0;i<featArray.length;i++) {
        			featureList.add(featArray[i]);
        		}
        	}
        	
        	propList = searchDAO.search(searchText,filterBy,bhk,rent,area,featureList);
        	
        	hashsetList = new HashSet<String>(propList);
        	list = new ArrayList<String>(hashsetList); 
        	 
            //DAO.close();
        } catch (AdException e) {
            System.out.println(e.getMessage());
        }
        
        ModelAndView mv = new ModelAndView("viewProp","propList",list);
 //       request.setAttribute("noOfPages", 3);
 //       request.setAttribute("currentPage", page);
        return mv;
    }
	
	
	@RequestMapping(value="/SaveProperty.htm",method=RequestMethod.GET)
    public String saveProperty(HttpServletRequest request, Model model) { 
		String id = request.getParameter("prop");
		Property property = null;
		PropertyDAO propertyDAO = new PropertyDAO();
		try {
			property = propertyDAO.get(id);
			propertyDAO.create(property.getApt(), property.getStreet(), property.getCity(), property.getState(), property.getZip(), property.getPhotoName(), property.getSeller(), property.getFeatures(), property.getRent(), property.getBhk(), property.getArea());
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   //     ModelAndView mv = new ModelAndView("viewProp","Property added");
//		model.addAttribute("PropAdded", "Property has been added!");
		
		return "viewProp";
    }
}
