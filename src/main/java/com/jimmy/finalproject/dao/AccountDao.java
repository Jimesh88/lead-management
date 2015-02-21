package com.jimmy.finalproject.dao;


import java.util.List;

import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Lead;






public interface AccountDao extends GenericDao<Account, Long>{

	
	List<Account> getMyAccounts(DbUser user);
	boolean removeAccount(Account account);
	boolean getLead(Lead lead);
}
