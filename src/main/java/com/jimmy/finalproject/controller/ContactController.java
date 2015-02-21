package com.jimmy.finalproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jimmy.finalproject.dao.AccountDao;
import com.jimmy.finalproject.dao.ContactDao;
import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.Contact;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Lead;
import com.jimmy.finalproject.validations.ContactValidator;



@RequestMapping("/contact")
@Controller
public class ContactController {
	@Autowired
	private ContactDao contactDao;
	
	@Autowired
	private AccountDao accountDao;

	
	@Autowired
	private ContactValidator contactValidator;
	
	@RequestMapping(method=RequestMethod.GET)
	public String newContact(Model model,HttpServletRequest request)
	{
		
		model.addAttribute("contact",new Contact());

		setList(model, request);
		return "contact/newContact";
		
	}
	
	private void setList(Model model,HttpServletRequest request)
	{
		
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		System.out.println("contact controller"+user.getUserName());
		List<Account> accounts= accountDao.getMyAccounts(user);
		model.addAttribute("accounts",accounts);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public String createContact(@ModelAttribute("contact")@Valid Contact contact,BindingResult result,@RequestParam("accountname")String id,HttpServletRequest request,Model model)
	{
		contactValidator.validate(contact, result);
		System.out.println("inside contact post");
		System.out.println("id"+id);
		if(id.equals("none"))
		{
			DbUser user = (DbUser) request.getSession(false).getAttribute("user");
			//System.out.println("contact controller"+user.getUserName());
			List<Account> accounts= accountDao.getMyAccounts(user);
			model.addAttribute("accounts",accounts);
			model.addAttribute("error","account cannot be empty");
			return "contact/newContact";
		}
		if(result.hasErrors())
		{
			DbUser user = (DbUser) request.getSession(false).getAttribute("user");
			System.out.println("contact controller"+user.getUserName());
			List<Account> accounts= accountDao.getMyAccounts(user);
			model.addAttribute("accounts",accounts);
			return "contact/newContact";
		}
		
		long lid = Long.parseLong(id);
		
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		contact.setUser(user);
		Account account=accountDao.find(lid);
		contact.setAccount(account);
		
		contactDao.add(contact);
		/*List<Contact> contacts=	contactDao.getMyContacts(user);
		model.addAttribute("contacts",contacts);*/
		return "redirect:/admin";
	}
	
	@RequestMapping(value="del/{id}",method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") long id)
	{
		System.out.println("inside delete");
		Contact c=contactDao.find(id);
		contactDao.remove(c);
		return "successfully deleted contact";
		
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getContact(@PathVariable("id") long id, Model model,HttpServletRequest request)
    {
		Contact c = contactDao.find(id);
		model.addAttribute("contact",c);
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		System.out.println("contact controller"+user.getUserName());
		
		List<Account> accounts= accountDao.getMyAccounts(user);
		model.addAttribute("accounts",accounts);
		return "contact/editContact";
		
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String updateAccount(@PathVariable("id") long id,@RequestParam("accountname")String i,@ModelAttribute("contact")@Valid Contact contact,BindingResult result,HttpServletRequest request,Model model) {
		contactValidator.validate(contact, result);
		
		if(result.hasErrors())
		{
			DbUser user = (DbUser) request.getSession(false).getAttribute("user");
			System.out.println("contact controller"+user.getUserName());
			model.addAttribute("contact",new Contact());
			List<Account> accounts= accountDao.getMyAccounts(user);
			model.addAttribute("accounts",accounts);
			return "contact/newContact";
		}
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		contact.setUser(user);
	   long idx=	Long.parseLong(i);
		Account account=accountDao.find(idx);
		contact.setAccount(account);
		contact.setContactId(id);
		contactDao.update(contact);
		return "redirect:/admin";

	}

	
	
}
