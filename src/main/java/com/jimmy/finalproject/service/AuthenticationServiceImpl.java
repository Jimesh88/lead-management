package com.jimmy.finalproject.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jimmy.finalproject.dao.UserDao;
import com.jimmy.finalproject.model.DbUser;





@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	UserDao userDao;
	
	
	@Override
	public DbUser authenticateUser(String userName, String password) {
		// TODO Auto-generated method stub
	 
		DbUser b = userDao.authenticate(userName, password);
		if(b == null)
		{
			System.out.println("b null");
			return null;
		
		}
		
		else if(b.getStatus().equals("Pending"))
		{
			return null;
			
		}
		else
			return b;
		
	}

	
	
		
}
