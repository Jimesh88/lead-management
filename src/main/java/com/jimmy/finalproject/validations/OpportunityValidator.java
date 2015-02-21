package com.jimmy.finalproject.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jimmy.finalproject.model.Lead;
import com.jimmy.finalproject.model.Opportunity;

public class OpportunityValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return Opportunity.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "closingDate", "typeMismatch.opportunity.closingDate");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stage", "stage.required");
		
		Opportunity opportunity = (Opportunity)target;
		
		if(opportunity.getExpectedRevenue()<0)
		{
			
			errors.rejectValue("expectedRevenue", "field.expectedRevenue.negative");
			
		}
		
	}

}
