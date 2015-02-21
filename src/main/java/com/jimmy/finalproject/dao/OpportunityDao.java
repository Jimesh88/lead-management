package com.jimmy.finalproject.dao;

import java.util.List;

import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Opportunity;







public interface OpportunityDao extends GenericDao<Opportunity, Long>{

		List<Opportunity> getMyOpportunities(DbUser user);
		List<Opportunity> getMyClosedOpportunities(DbUser user);
		List<Opportunity> getMyOpenOpportunities(DbUser user);
		boolean getAccount(Account account);
	

	
}
