package com.jimmy.finalproject.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jimmy.finalproject.dao.AccountDao;
import com.jimmy.finalproject.dao.LeadDao;
import com.jimmy.finalproject.exceptions.AccountDeleteException;
import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Lead;
import com.jimmy.finalproject.validations.AccountValidator;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountDao accountDao;

	@Autowired
	LeadDao leadDao;
	
	@Autowired
	AccountValidator accountValidator;

	@RequestMapping(method = RequestMethod.GET)
	public String newAccount(Model model) {
		model.addAttribute("account", new Account());
		
		setList(model);
		return "account/newAccount";
	}

	private void setList(Model model)
	{
		List<String> companies = Arrays.asList(Lead.leadIndustryArray);
		
		model.addAttribute("companies", companies);
		List<Lead> leads = leadDao.getAllConvertedLead();
		model.addAttribute("leads", leads);
		List<String> ratings = Arrays.asList(Account.accountRatings);
		model.addAttribute("ratings", ratings);
		List<String> accountTypes = Arrays.asList(Account.accountTypes);
		model.addAttribute("types", accountTypes);
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addAccount(
			
			@RequestParam("leadname") String id,
			@RequestParam("accountRating")String accountRating,
			@RequestParam("mytext") String notes, HttpServletRequest request,
			@ModelAttribute("account")@Valid Account account,BindingResult result, Model model) {
		accountValidator.validate(account, result);
		//System.out.println("*********account post my page id "+ mypageid);
		if(result.hasErrors())
		{
			setList(model);
			return "account/newAccount";
			
		}
		System.out.println("inside account post");
		
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		account.setAccountRating(accountRating);
		
		account.setUser(user);
		System.out.println(account.getUser().getUserName());
		if(!id.equals(""))
		{
			long i = Long.parseLong(id);
			Lead l = leadDao.find(i);
			account.setLead(l);
		}
		
		
			
		
		account.setNotes("notes" + notes);

		
		accountDao.add(account);
		
		return "redirect:/admin?#tab-1";
	}

	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String editAccount(@PathVariable("id") long id,Model model)
	{
		Account account = accountDao.find(id);
		
		model.addAttribute("account",account);
		List<String> companies = Arrays.asList(Lead.leadIndustryArray);
		
		model.addAttribute("companies", companies);
		List<Lead> leads = leadDao.getAllConvertedLead();
		model.addAttribute("leads", leads);
		List<String> ratings = Arrays.asList(Account.accountRatings);
		model.addAttribute("ratings", ratings);
		List<String> accountTypes = Arrays.asList(Account.accountTypes);
		model.addAttribute("types", accountTypes);
		return "account/editAccount";
		
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String update(@PathVariable("id")long id,@RequestParam("accountRating")String accountRating, @ModelAttribute("account")@Valid Account account,BindingResult result,HttpServletRequest request)
	{
		System.out.println("id"+id);
		accountValidator.validate(account, result);
		
		if(result.hasErrors())
		{
			return "account/editAccount";
		}
		System.out.println("inside update");
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		account.setAccountId(id);
		account.setUser(user);
		account.setAccountRating(accountRating);
		System.out.println(account.getUser().getUserName());
		accountDao.update(account);
		return "redirect:/admin";
		
	}
	
	
	@RequestMapping(value = "del/{id}", method = RequestMethod.DELETE)
	public @ResponseBody String deleteAccount(@PathVariable("id") long id)
			throws AccountDeleteException {
		
		Account account = accountDao.find(id);
		boolean wasDeleted = accountDao.removeAccount(account);
		if (wasDeleted==false) {
			
			return "false";
			
		}
		System.out.println("inside delete");
		return "successfully deleted";

	}

	@ExceptionHandler(AccountDeleteException.class)
	public ModelAndView handleException(AccountDeleteException e) {
		ModelMap model = new ModelMap();
		model.put("task", e.getAccount());
		return new ModelAndView("account/delete-error", model);

	}

	
}
