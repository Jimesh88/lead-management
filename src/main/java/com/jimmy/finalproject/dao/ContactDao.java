package com.jimmy.finalproject.dao;
import java.util.List;

import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.Contact;
import com.jimmy.finalproject.model.DbUser;



public interface ContactDao extends GenericDao<Contact, Long> {
	
	
	List<Contact> getMyContacts(DbUser user);
	
	boolean getAccount(Account account);
}
