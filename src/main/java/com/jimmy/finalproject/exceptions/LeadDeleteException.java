package com.jimmy.finalproject.exceptions;

import com.jimmy.finalproject.model.Account;
import com.jimmy.finalproject.model.Lead;

public class LeadDeleteException extends Exception{
private Lead lead;
	
	public LeadDeleteException(Lead lead)
	{
		this.lead=lead;
	}

	public Lead getlead()
	{
		return lead;
	}
}
