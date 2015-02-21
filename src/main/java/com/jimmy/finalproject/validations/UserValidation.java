package com.jimmy.finalproject.validations;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.jimmy.finalproject.model.DbUser;


public class UserValidation implements Validator{

	@Override
	public boolean supports(Class<?> aClass) {
		// TODO Auto-generated method stub
		return  DbUser.class.isAssignableFrom(aClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName is required");
		
		DbUser user = (DbUser)target;
		
		if (!(user.getPassword()).equals(user
		        .getConfirmPassword())){
			
				errors.rejectValue("password", "Password and Confirm Password Not match", "Password and Confirm Password Not match.");
			
			
		}
		 if ((user.getUserName().length()) > 30) {
		      errors.rejectValue("userName",
		          "lengthOfUser.registration.userName",
		          "User Name must not more than 50 characters.");
		    }
		
	}

}
