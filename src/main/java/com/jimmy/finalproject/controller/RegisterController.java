package com.jimmy.finalproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jimmy.finalproject.dao.RoleDao;
import com.jimmy.finalproject.dao.UserDao;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.JsonResponse;
import com.jimmy.finalproject.model.Opportunity;
import com.jimmy.finalproject.model.Role;
import com.jimmy.finalproject.validations.UserValidation;

@Controller
@RequestMapping("register")
public class RegisterController {
	
	@Autowired
	RoleDao roleDao;
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserValidation userValidation;
		
	
	
	@RequestMapping(method=RequestMethod.POST)
	public @ResponseBody JsonResponse addUser(Model model,@ModelAttribute("user")DbUser user,BindingResult result,@RequestParam("userName")String userName,@RequestParam("password")String password,String confirmPassword,@RequestParam("department")String department)

	{
		System.out.println("inside register post");
	
		user.setDepartment(department);
		user.setStatus("Pending");
		
		JsonResponse res = new JsonResponse();
		userValidation.validate(user, result);
		if(result.hasErrors())
		{
			System.out.println(result.getAllErrors().size());
			
			res.setResult(result.getAllErrors());
			res.setStatus("Fail");
			return res;
		
		}
		
		long id=2;
		Role role=roleDao.find(id);
		user.setRole(role);
	    DbUser u=	userDao.authenticate(user.getUserName(), user.getPassword());
	  if(u!=null)
	  {
		res.setStatus("userExist");
		return res;
		
	  }
		userDao.add(user);
		res.setStatus("Success");
		return res;
		
	}


}
