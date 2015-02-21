package com.jimmy.finalproject.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jimmy.finalproject.dao.AccountDao;
import com.jimmy.finalproject.dao.ContactDao;
import com.jimmy.finalproject.dao.LeadDao;
import com.jimmy.finalproject.dao.OpportunityDao;
import com.jimmy.finalproject.dao.UserDao;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.service.AuthenticationService;


@Controller
public class LoginController {

	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	LeadDao leadDao;
	
	@Autowired
	ContactDao contactDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	OpportunityDao opportunityDao;
	

	
	@RequestMapping(value="/",method = RequestMethod.GET)
	public String getLogin(Model model) {
		model.addAttribute("user",new DbUser());
		System.out.println("login get");
		return "login";
		
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String authenticate(@RequestParam("userName") String userName,@RequestParam("password")String password,Model model,HttpServletRequest request,HttpSession session)
	{
		System.out.println("inside post");
		DbUser user = (DbUser) authenticationService.authenticateUser(userName, password);
		session.invalidate();
		session = request.getSession(true);
		
		
		if(user == null)
		{
			System.out.println("inside null");
			model.addAttribute("error","user not found");
			
			return"login";
		}
		
		else if(user.getRole().getRoleName().equals("Admin"))
		{
			session.setAttribute("user", user);
			
			return "redirect:/admin";
			
		}
		
		session.setAttribute("user", user);
		return "redirect:/normal";
		
	}
	
	
	
	
	
}
