package com.neu.project.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.Property;

@Component
public class AdvertValidator implements Validator {

	private static final String FIELD_PATTERN = "^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$";

	public boolean supports(Class aClass)
    {
        return aClass.equals(Property.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Property newAdvert = (Property) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apt", "error.invalid.user", "apt Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "error.invalid.user", "street Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.user", "city Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.user", "state Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.invalid.user", "zip Required");
//      ValidationUtils.rejectIfEmptyOrWhitespace(errors, "photoName", "error.invalid.user", "Street Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "rent", "error.invalid.user", "rent Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bhk", "error.invalid.user", "bhk Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "area", "error.invalid.user", "area Required");
        
        Pattern pattern = Pattern.compile(FIELD_PATTERN);
        
        Matcher matcher1 = pattern.matcher(newAdvert.getApt());
        Matcher matcher2 = pattern.matcher(newAdvert.getStreet());
        Matcher matcher3 = pattern.matcher(newAdvert.getCity());
        Matcher matcher4 = pattern.matcher(newAdvert.getState());
        Matcher matcher5 = pattern.matcher(newAdvert.getZip());
        
        if(!matcher1.matches()) {
        	errors.rejectValue("apt","Test","Invalid Apartment");
        }
        
        if(!matcher2.matches()) {
        	errors.rejectValue("street","Test","Invalid Street");
        }
        
        if(!matcher3.matches()) {
        	errors.rejectValue("city","Test","Invalid City");
        }
        
        
        if(!matcher4.matches()) {
        	errors.rejectValue("state","Test","Invalid State");
        }
        
        if(!matcher5.matches()) {
        	errors.rejectValue("zip","Test","Invalid Zip");
        }
          
    }
}
