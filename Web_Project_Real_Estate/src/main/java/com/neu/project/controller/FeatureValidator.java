package com.neu.project.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.neu.project.pojo.Features;


@Component
public class FeatureValidator implements Validator{
    public boolean supports(Class aClass)
    {
        return aClass.equals(Features.class);
    }

    public void validate(Object obj, Errors errors)
    {
    	Features newFeatures = (Features) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "featureDesc", "error.invalid.Feature", "Feature Required");
    }

}
