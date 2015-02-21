package com.jimmy.finalproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jimmy.finalproject.model.DbUser;



@Repository("userDao")
@Qualifier("userDao")
public class UserDaoImpl extends HibernateDoa<DbUser, Long> implements UserDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<DbUser> getAllAdminUsers(long id) {
		// TODO Auto-generated method stub
		Query queryManager = currentSession().createQuery("from user u where u.role.roleId=:id");
		queryManager.setParameter("id", 1);
		if(queryManager.list().isEmpty())
		{
			return null;
			
		}
		
		return queryManager.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DbUser> getAllNormalUsers(long id) {
		// TODO Auto-generated method stub
		Query queryManager = currentSession().createQuery("from user u where u.role.roleId=:id");
		queryManager.setParameter("id", 2);
		if(queryManager.list().isEmpty())
		{
			return null;
			
		}
		
		return queryManager.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DbUser> getAllGuestUsers(long id) {
		// TODO Auto-generated method stub
		Query queryManager = currentSession().createQuery("from user u where u.role.roleId=:id");
		queryManager.setParameter("id", 3);
		if(queryManager.list().isEmpty())
		{
			return null;
			
		}
		
		return queryManager.list();
	}

	@SuppressWarnings("unused")
	@Override
	public DbUser authenticate(String userName,String password) {
		// TODO Auto-generated method stub
		Query queryManager = currentSession().createQuery("from DbUser u where u.userName=:username and u.password=:pass");
		queryManager.setParameter("username",userName);
		queryManager.setParameter("pass",password);
		DbUser user=(DbUser) queryManager.uniqueResult();
		
	   
		
		
		
		if(user==null)
		{
			return null;
		}
		else
			System.out.println("role: "+user.getRole().getRoleName());
			System.out.println(user.getUserName());
			return user;
		
	}

}
