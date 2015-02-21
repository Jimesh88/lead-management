package com.jimmy.finalproject.service;

import com.jimmy.finalproject.model.DbUser;



public interface AuthenticationService {

		DbUser authenticateUser(String userName,String password);
	
}
