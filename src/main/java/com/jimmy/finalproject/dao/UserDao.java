package com.jimmy.finalproject.dao;

import java.util.List;

import com.jimmy.finalproject.model.DbUser;





public interface UserDao extends GenericDao<DbUser, Long>{
	List<DbUser> getAllAdminUsers(long id);
	List<DbUser> getAllNormalUsers(long id);
	List<DbUser> getAllGuestUsers(long id);
	DbUser authenticate(String userName,String password);

	
	
}
