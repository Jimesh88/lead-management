package com.jimmy.finalproject.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.Lead;


public class AccountValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return Account.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
	
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "accountName", "accountname.required");
			Account account = (Account)target;
			
			if(account.getAnnualRevenue()<0)
			{
				
			}
			if(account.getBillingZip()<0)
			{
				errors.rejectValue("billingZip", "field.zip.negative");
				
			}
			if(account.getNumberOfEmployees()<0)
			{
				
				errors.rejectValue("numberOfEmployees", "field.numberOfEmployees");
			}
			if(account.getPhoneNo()<0)
			{
				errors.rejectValue("phoneNo", "field.phoneNo.negative");
				
			}
			if(account.getShippingZip()<0)
			{
				errors.rejectValue("shippingZip", "field.zip.negative");
				
			}
			if(account.getFax()<0)
			{
				errors.rejectValue("fax", "field.fax.negative");
				
			}
			
				
		
	}

}
