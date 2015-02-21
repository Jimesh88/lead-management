package com.jimmy.finalproject.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jimmy.finalproject.dao.AccountDao;
import com.jimmy.finalproject.dao.OpportunityDao;
import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Opportunity;
import com.jimmy.finalproject.validations.OpportunityValidator;



@Controller
@RequestMapping("/opportunity")
public class OpportunityController {
	@Autowired
	AccountDao accountDao;

	@Autowired
	OpportunityDao opportunityDao;
	
	@Autowired
	OpportunityValidator opportunityValidator;
	
	

	@RequestMapping(method = RequestMethod.GET)
	public String newOpportunity(Model model, HttpServletRequest request) {

		setList(model, request);
		model.addAttribute("opportunity", new Opportunity());
		return "opportunity/newOpportunity";

	}
	
	
	private void setList(Model model,HttpServletRequest request)
	{
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		
		List<Account> accounts = accountDao.getMyAccounts(user);
		List<String> stages = Arrays.asList(Opportunity.opportunityStages);
		model.addAttribute("stages", stages);
		model.addAttribute("accounts", accounts);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String getOpportunity(@ModelAttribute("opportunity")@Valid Opportunity o,BindingResult result, Model model,
			@RequestParam("accountname") String id,
			 HttpServletRequest request) {
		
		opportunityValidator.validate(o, result);
		
		if(id.equals("none"))
		{
			setList(model, request);
			model.addAttribute("error","account cannot be empty");
			return "opportunity/newOpportunity";
			
		}
		
		if(result.hasErrors())
		{
			
			return "opportunity/newOpportunity";
			
		}
		
		long lid = Long.parseLong(id);
		System.out.println("inside contact post");
		System.out.println("id" + id);
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		
		System.out.println(o.getClosingDate());
		Account account = accountDao.find(lid);
		o.setUser(user);
		o.setAccount(account);
		
		opportunityDao.add(o);
		
		List<Opportunity> os = opportunityDao.getMyOpenOpportunities(user);
		model.addAttribute("opportunities", os);
		return "redirect:/admin";

	}
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteOpportunity(@PathVariable("id") long id) {
		System.out.println("inside opportunity delete");
		Opportunity o = opportunityDao.find(id);
		opportunityDao.remove(o);
		return "redirect:/admin";

	}
	
	/*@RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteOpportunity(@PathVariable("id") long id) {
		System.out.println("inside opportunity delete");
		String resultText="";
		Opportunity o = opportunityDao.find(id);
		opportunityDao.remove(o);
		resultText="successfully deleted opportunity";
		return resultText;

	}
	*/
	
	@RequestMapping(value="/{id}",method= RequestMethod.GET)
	public String editOpportunity(@PathVariable("id")long id,Model model,HttpServletRequest request)
	{
		Opportunity o = opportunityDao.find(id);
		model.addAttribute("opportunity",o);
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
	
		List<Account> accounts = accountDao.getMyAccounts(user);
		List<String> stages = Arrays.asList(Opportunity.opportunityStages);
		model.addAttribute("stages", stages);
		model.addAttribute("accounts", accounts);
		
		return "opportunity/editOpportunity";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String update(@ModelAttribute("opportunity") Opportunity o,@RequestParam("accountname") String i,Model model,@PathVariable("id") long id,HttpServletRequest request,BindingResult result)
	{
		opportunityValidator.validate(o, result);
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		if(result.hasErrors())
		{
			
			
			List<Account> accounts = accountDao.getMyAccounts(user);
			List<String> stages = Arrays.asList(Opportunity.opportunityStages);
			model.addAttribute("stages", stages);
			model.addAttribute("accounts", accounts);
			
			return "opportunity/newOpportunity";
		}
		long lid = Long.parseLong(i);
		
		Account account = accountDao.find(lid);
		o.setOpportunityId(id);
		o.setUser(user);
		o.setAccount(account);
		opportunityDao.update(o);
		return "redirect:/admin";
		
		
	}

}
