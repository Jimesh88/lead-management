package com.jimmy.finalproject.dao;
import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jimmy.finalproject.model.Lead;


@Repository("leadDao")
public class LeadDaoImpl extends HibernateDoa<Lead, Long> implements LeadDao{

	
	@Autowired
	AccountDao accountDao;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Lead> getAllClosedLeads() {
		// TODO Auto-generated method stub
		
		Query manageQuery = currentSession().createQuery("from Lead l where l.leadStatus=:status");
		manageQuery.setParameter("status", "Lost Lead");
		
		if(manageQuery.list().isEmpty())
		{
			return null;
			
		}
		
		return manageQuery.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lead> getAllJunkLeads() {
		// TODO Auto-generated method stub
		Query manageQuery = currentSession().createQuery("from Lead l where l.leadStatus=:status");
		manageQuery.setParameter("status", "Junk Lead");
		
		
	  if(manageQuery.list().isEmpty())
		{
			return null;
			
		}
		
		return manageQuery.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lead> getAllConvertedLead() {
		// TODO Auto-generated method stub
		Query manageQuery = currentSession().createQuery("from Lead l where l.leadStatus=:status");
		manageQuery.setParameter("status", "Converted");
		
		if(manageQuery.list().isEmpty())
		{
			return null;
			
		}
		
		return manageQuery.list();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Lead> getAllOpenLead() {
		// TODO Auto-generated method stub
		
		Query manageQuery = currentSession().createQuery("from Lead l where l.leadStatus in= :list");
		
		String leadOpenStatusArry[] = {"Not Contacted","Attempted to contact","Contacted"};
		
		manageQuery.setParameterList("list", leadOpenStatusArry);
		if(manageQuery.list().isEmpty())
		{return null;}
		return manageQuery.list();
	}

	@Override
	public Lead getLeadbyCompany(String companyName) {
		// TODO Auto-generated method stub
		Query q = currentSession().createQuery("from Lead l where l.companyName=:name");
		q.setParameter("name", companyName);
		return null;
	}

	@Override
	public boolean removeLead(Lead l) {
		// TODO Auto-generated method stub
		boolean b = accountDao.getLead(l);
		if(b==false)
		{
			return false;
		}
		remove(l);
		return true;
	}

}
