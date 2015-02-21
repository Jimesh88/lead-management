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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jimmy.finalproject.dao.LeadDao;
import com.jimmy.finalproject.exceptions.AccountDeleteException;
import com.jimmy.finalproject.exceptions.LeadDeleteException;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Lead;
import com.jimmy.finalproject.validations.LeadValidator;






@Controller
@RequestMapping("/lead")
public class LeadController{

	@Autowired
	LeadDao leadDao;
	
	
	@Autowired
	LeadValidator leadValidator;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public String getNewLead(Model model) {
		System.out.println("inside lead get");
		model.addAttribute("lead",new Lead());
		setList(model);
		return "lead/newLead";

	}
	private void setList(Model model)
	{
		
		List<String>status = Arrays.asList(Lead.leadStatusArray);
		List<String>companies=Arrays.asList(Lead.leadIndustryArray);
		List<String>source=Arrays.asList(Lead.leadSourceArray);
		model.addAttribute("source",source);
		model.addAttribute("companies",companies);
		model.addAttribute("status",status);
		
		
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String createLead(@ModelAttribute("lead")@Valid Lead lead,BindingResult result,HttpServletRequest request,Model model) {
		
		leadValidator.validate(lead, result);
		if(result.hasErrors())
		{
			setList(model);
			return "lead/newLead";
		}
		
		System.out.println("inside post");
		DbUser user = (DbUser) request.getSession(false).getAttribute("user");
		System.out.println(user.getUserName());
		
		leadDao.add(lead);
		
		return "redirect:/admin";

	}
	
	
	@RequestMapping(value="del/{id}",method=RequestMethod.DELETE)
	public @ResponseBody String delete(@PathVariable("id") long id) throws LeadDeleteException
	{
		System.out.println("inside delete");
		Lead lead=leadDao.find(id);
		boolean b = leadDao.removeLead(lead);
		if(!b)
		{
			throw new LeadDeleteException(lead);
		}
		
		return "successfully deleted lead";
		
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String editLead(@PathVariable("id") long id,Model model)
	{
		Lead l = leadDao.find(id);
		System.out.println("edit lead"+l.getFirstName());
		model.addAttribute("lead",l);
		List<String>status = Arrays.asList(Lead.leadStatusArray);
		List<String>companies=Arrays.asList(Lead.leadIndustryArray);
		List<String>source=Arrays.asList(Lead.leadSourceArray);
		model.addAttribute("source",source);
		model.addAttribute("companies",companies);
		model.addAttribute("status",status);
		return "lead/editLead";
		
		
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String update(@PathVariable("id")long id, @ModelAttribute("lead")@Valid Lead lead,BindingResult result)
	{
		System.out.println("id"+id);
		leadValidator.validate(lead, result);
		
		if(result.hasErrors())
		{
			return "lead/editLead";
		}
		System.out.println("inside update");
		lead.setLeadId(id);
		leadDao.update(lead);
		return "redirect:/admin";
		
	}
	
	@ExceptionHandler(LeadDeleteException.class)
	public ModelAndView handleException(LeadDeleteException e)
	{
		 ModelMap model = new ModelMap();
	     model.put("task", e.getlead());
	     return new ModelAndView("lead/delete-error", model);
		
	}
	
	
}
