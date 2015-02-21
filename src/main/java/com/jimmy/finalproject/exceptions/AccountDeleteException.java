package com.jimmy.finalproject.exceptions;

import com.jimmy.finalproject.model.Account;

public class AccountDeleteException extends Exception{

	private Account account;
	
	public AccountDeleteException(Account account)
	{
		this.account=account;
	}

	public Account getAccount()
	{
		return account;
	}
}
