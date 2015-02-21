package com.jimmy.finalproject.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jimmy.finalproject.model.Lead;

public class LeadValidator implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return Lead.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "companyName", "companyName.required");
		
		
		Lead lead = (Lead)target;
		
		
		if(lead.getZip()<0)
		{
			errors.rejectValue("zip", "field.zip.negative");
		}
		if(lead.getMobileNo()<0)
		{
			errors.rejectValue("mobileNo", "field.mobileNo.negative");
		}
		if(lead.getPhoneNo()<0)
		{
			errors.rejectValue("phoneNo", "field.phoneNo.negative");
		}
		
		/*String str=	Integer.toString(lead.getZip());
		if(!isNumber(str))
		{
			
			errors.rejectValue("zip", "field.zip.NAN");
		}
		
		String str2 = Integer.toString(lead.getMobileNo());
		if(!isNumber(str2))
		{
			errors.rejectValue("mobileNo", "field.mobieNo.NAN");
			
		}
		String str3 = Integer.toString(lead.getPhoneNo());
		if(!isNumber(str3));
		{
			
			errors.rejectValue("phoneNo", "field.phoneNo.NAN");
		}*/
		
	}
	
	
	private boolean isNumber(String str){
	    for (int i = 0; i < str.length(); i++) {
	        
	        //If we find a non-digit character we return false.
	        if (!Character.isDigit(str.charAt(i)))
	        return false;
	        }
	         
	        return true;
	}


	

}
