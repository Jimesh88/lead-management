package com.jimmy.finalproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Opportunity;


@Repository
@Qualifier("opportunityDao")
public class OpportunityDaoImpl extends HibernateDoa<Opportunity, Long> implements OpportunityDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Opportunity> getMyOpportunities(DbUser user) {
		// TODO Auto-generated method stub
		
		System.out.println("user id"+user.getUserId());
	    Query manageQuery = currentSession().createQuery("from Opportunity o where o.user.userId=:id");
		
		manageQuery.setParameter("id", user.getUserId());
		if(manageQuery.list().isEmpty())
		{
			System.out.println("inside null");
			return null;
				
		}
		List<Opportunity> os =  manageQuery.list();
		for(Opportunity o : os)
		{
			System.out.println("hi "+o.getAccount().getUser());
			
		}
		
		return manageQuery.list();	
	}

	

	

	@Override
	public List<Opportunity> getMyClosedOpportunities(DbUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Opportunity> getMyOpenOpportunities(DbUser user) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public boolean getAccount(Account account) {
		// TODO Auto-generated method stub
		Query q = currentSession().createQuery("from Opportunity o where o.account.accountId=:id");
		q.setParameter("id", account.getAccountId());
		if(!q.list().isEmpty())
		{
			return false;
		}
		return true;
	}

}
