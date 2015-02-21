package com.jimmy.finalproject.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;


import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Lead;

@Repository("accountDao")
@Qualifier("accountDao")
public class AccountDaoImpl extends HibernateDoa<Account, Long> implements
		AccountDao {

	@Autowired
	OpportunityDao opportunityDao;
	
	@Autowired
	ContactDao contactDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Account> getMyAccounts(DbUser user) {
		// TODO Auto-generated method stub
		System.out.println("get my accounts" + user.getUserName());
		Query manageQuery = currentSession().createQuery(
				"from Account a where a.user.userId=:id");

		manageQuery.setParameter("id", user.getUserId());
		List<Account> as = manageQuery.list();
		for (Account a : as) {
			System.out.println(a.getUser().getUserName());
			System.out.println(a.getUser().getRole().getRoleName());

		}
		if (manageQuery.list().isEmpty()) {
			return null;

		}

		return manageQuery.list();
	}

	@Override
	public boolean removeAccount(Account account) {
		// TODO Auto-generated method stub
		boolean b = opportunityDao.getAccount(account);
		boolean c = contactDao.getAccount(account);
		if (b==false||c==false) {
			return false;
		}

		// ok, remove as usual
		remove(account);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	    public List<Account> list() {
	        return currentSession().createCriteria(Account.class)
	                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
	                .list();
	    }

	@Override
	public boolean getLead(Lead lead) {
		// TODO Auto-generated method stub
		Query q = currentSession().createQuery("from Account a where a.lead.leadId=:id");
		q.setParameter("id", lead.getLeadId());
		if(!q.list().isEmpty())
		{
			return false;
		}
		return true;
	}
	
}
