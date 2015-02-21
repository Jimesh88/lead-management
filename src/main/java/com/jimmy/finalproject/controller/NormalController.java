package com.jimmy.finalproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jimmy.finalproject.dao.AccountDao;
import com.jimmy.finalproject.dao.ContactDao;
import com.jimmy.finalproject.dao.LeadDao;
import com.jimmy.finalproject.dao.OpportunityDao;
import com.jimmy.finalproject.dao.UserDao;
import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.Contact;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Lead;
import com.jimmy.finalproject.model.Opportunity;

@Controller
@RequestMapping("/normal")
public class NormalController {
	@Autowired
	LeadDao leadDao;
	
	@Autowired
	ContactDao contactDao;
	
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	OpportunityDao opportunityDao;
	
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getNormalPage(Model model,HttpServletRequest request)
	{
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		List<Lead> leads = leadDao.list();
		model.addAttribute("leads",leads);
		List<Account>accounts=accountDao.getMyAccounts(user);
		model.addAttribute("accounts",accounts);
		List<Contact>contacts=contactDao.getMyContacts(user);
		model.addAttribute("contacts",contacts);
		List<Opportunity> os = opportunityDao.getMyOpportunities(user);
		model.addAttribute("opportunities",os);
		return  "normalPage";
		
	}
}
