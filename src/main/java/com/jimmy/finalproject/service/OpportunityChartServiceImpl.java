package com.jimmy.finalproject.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.context.CurrentSessionContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Service;

import com.jimmy.finalproject.dao.HibernateDoa;
import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Opportunity;

@Service("opportunityChartService")
public class OpportunityChartServiceImpl extends HibernateDoa<Opportunity, Long> implements OpportunityChartService{
	@SuppressWarnings("unchecked")
	@Override
	public List<Opportunity> getOpportunitiesByMonth(String month,DbUser user) {
		// TODO Auto-generated method stub
		System.out.println(month);
		Query q = currentSession().createQuery("from Opportunity o where month(o.closingDate)="+month+" and o.user.userId=:id");
		q.setParameter("id", user.getUserId());
		
	List<Opportunity> olist=q.list();
		for(Opportunity o:olist)
		{
			System.out.println(o.getStage());
		}
		
		if(olist.isEmpty())
		{
			return null;
		}
		else 
			return olist;
		
	}

}
