package com.jimmy.finalproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jimmy.finalproject.dao.RoleDao;
import com.jimmy.finalproject.dao.UserDao;
import com.jimmy.finalproject.model.CallBack;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Role;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserDao userDao;
	
	@Autowired
	RoleDao roleDao;
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String  getUser(@PathVariable("id")long id,Model model)
	{
		
		DbUser user = userDao.find(id);
		model.addAttribute("user",user);
		return "user/editUser";
		
	}
	@RequestMapping(value="/{id}",method=RequestMethod.POST)
	public String update(@PathVariable("id")long id,@Valid DbUser user,@RequestParam("roleName")String idx,@RequestParam("department")String department,@RequestParam("status")String status)
	{
		long roleId = Long.parseLong(idx);
		Role role = roleDao.find(roleId);
		user.setRole(role);
		user.setUserId(id);
		user.setDepartment(department);
		user.setStatus(status);
		userDao.update(user);
		return "redirect:/admin";
		
		
	}
	
/*	@RequestMapping(value="del/{id}")
	public @ResponseBody CallBack deleteUser(@PathVariable("id")long id,HttpServletRequest request,Model model)
	{
		CallBack cb = new CallBack();
		DbUser u = (DbUser)request.getSession().getAttribute("user");
	
		DbUser user = userDao.find(id);
		if(u.equals(user))
		{
			cb.setReturnString("cannot delete the current signed in user");;
			return cb;
		}
			
		
		userDao.remove(user);
		cb.setReturnString("successfully deleted user");
		return cb;
		
	}*/
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public String deleteUser(@PathVariable("id")long id,HttpServletRequest request,Model model)
	{
		DbUser u = (DbUser)request.getSession().getAttribute("user");
	
		DbUser user = userDao.find(id);
		if(u.equals(user))
		{
			model.addAttribute("error","cannot delete current user");
			return "redirect:/admin";
		}
			
		
		userDao.remove(user);
		return "redirect:/admin";
		
	}
	
}
