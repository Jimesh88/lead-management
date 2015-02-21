package com.jimmy.finalproject.dao;

import java.util.List;

import com.jimmy.finalproject.model.Lead;






public interface LeadDao extends GenericDao<Lead,Long>{
	
	 
	 List<Lead> getAllOpenLead();
	 List<Lead> getAllClosedLeads();
	 List<Lead> getAllJunkLeads();
	 List<Lead> getAllConvertedLead();
	 Lead getLeadbyCompany(String companyName);
	
	 
	 
	boolean removeLead(Lead l);
	
	
}
