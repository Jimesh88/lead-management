package com.jimmy.finalproject.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jimmy.finalproject.dao.AccountDao;
import com.jimmy.finalproject.model.Contact;
import com.jimmy.finalproject.model.Lead;

public class ContactValidator implements Validator {


	
	
	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return Contact.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.required");
		
		
	
		Contact contact =(Contact)target;
		

		if(contact.getMobileNo()<0)
		{
			errors.rejectValue("mobileNo", "field.mobileNo.negative");
		}
		if(contact.getZip()<0)
		{
			errors.rejectValue("zip", "field.zip.negative");
		}
		
		if(contact.getOfficeNo()<0)
		{
			errors.rejectValue("officeNo", "field.officeNo.negative");
			
		}
	}

}
