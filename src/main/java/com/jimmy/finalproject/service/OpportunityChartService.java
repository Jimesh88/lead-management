package com.jimmy.finalproject.service;

import java.util.List;

import com.jimmy.finalproject.model.DbUser;
import com.jimmy.finalproject.model.Opportunity;

public interface OpportunityChartService {
	
	List<Opportunity> getOpportunitiesByMonth(String year,DbUser User);
	
	
}
