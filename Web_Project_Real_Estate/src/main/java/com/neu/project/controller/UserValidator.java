
package com.neu.project.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
import com.neu.project.pojo.User;


import org.springframework.validation.ValidationUtils;

public class UserValidator implements Validator {

	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String DATE_PATTERN = "((?:19|20)\\d\\d)-(0?[1-9]|1[012])-([12][0-9]|3[01]|0?[1-9])";
	private static final String FIELD_PATTERN = "^[A-Za-z0-9 _]*[A-Za-z0-9][A-Za-z0-9 _]*$";
	
	public boolean supports(Class aClass)
    {
        return aClass.equals(User.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    	Pattern pattern1 = Pattern.compile(DATE_PATTERN);
    	Pattern pattern2 = Pattern.compile(FIELD_PATTERN);
    	
    	
    	Matcher matcher;
    	Matcher matcher1;
    	Matcher matcher2;
    	
        User user = (User) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "First Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.invalid.user", "Last Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "error.invalid.user", "Date of Birth Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.invalid.user", "Email Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.invalid.user", "Phone number Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street", "error.invalid.user", "Street Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city", "error.invalid.user", "City Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "state", "error.invalid.user", "State Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zip", "error.invalid.user", "Zip Required");
        
        matcher = pattern.matcher(user.getEmail());
        matcher1 = pattern1.matcher(String.valueOf(user.getDob()));
        matcher2 = pattern2.matcher(user.getFirstName());
        Matcher matcher3 = pattern2.matcher(user.getLastName());
        Matcher matcher4 = pattern2.matcher(user.getStreet());
        Matcher matcher5 = pattern2.matcher(user.getCity());
        Matcher matcher6 = pattern2.matcher(user.getState());
        Matcher matcher7 = pattern2.matcher(user.getZip());
        
        
        
        if(!matcher.matches()) {
        	errors.rejectValue("email","Test","Invalid Email");
        }
        
        if(!matcher1.matches()) {
        	errors.rejectValue("dob","Test","Invalid Date Format");
        	
            
        if(!matcher2.matches()) {
           	errors.rejectValue("firstName","Test","Invalid First name");
           }
        	
        if(!matcher3.matches()) {
        	errors.rejectValue("lastName","Test","Invalid Last name");
           }
        
        if(!matcher4.matches()) {
        	errors.rejectValue("street","Test","Invalid Street name");
           }
        
        if(!matcher5.matches()) {
        	errors.rejectValue("city","Test","Invalid City name");
           }
        
        if(!matcher6.matches()) {
        	errors.rejectValue("state","Test","Invalid State name");
           }
        
        if(!matcher7.matches()) {
        	errors.rejectValue("zip","Test","Invalid Zip name");
           }
        
        }
    }
}
