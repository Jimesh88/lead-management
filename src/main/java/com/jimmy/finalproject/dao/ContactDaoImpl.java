package com.jimmy.finalproject.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.Contact;
import com.jimmy.finalproject.model.DbUser;



@Repository("contactDao")
public class ContactDaoImpl extends HibernateDoa<Contact, Long> implements ContactDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> getMyContacts(DbUser user) {
		// TODO Auto-generated method stub
		
		Query queryManager = currentSession().createQuery("from Contact c where c.user.userId = :id");
		queryManager.setParameter("id", user.getUserId());
		if(queryManager.list().isEmpty())
		{
			return null;
			
		}
		List<Contact> cs = queryManager.list();
		for(Contact c : cs)
		{
			System.out.println(c.getAccount().getAccountName());
			System.out.println(c.getUser());
			
		}
		
		return queryManager.list();
	}

	@Override
	public boolean getAccount(Account account) {
		// TODO Auto-generated method stub
		Query q = currentSession().createQuery("from Contact o where o.account.accountId=:id");
		q.setParameter("id", account.getAccountId());
		if(!q.list().isEmpty())
		{
			return false;
		}
		return true;
	}
	
	

}
