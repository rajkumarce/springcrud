package com.mrk.bankacc.web;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import com.mrk.bankacc.model.AccountType;
import com.mrk.bankacc.service.BankService;

public class AccountTypeFormatter implements Formatter<AccountType> {
	
	private final BankService bankService;

	@Autowired
	public AccountTypeFormatter(BankService bankService){
		this.bankService = bankService;
	}
	
	@Override
	public String print(AccountType accType, Locale locale){
		return accType.getName();
	}
	
	@Override
	public AccountType parse(String text, Locale locale) throws ParseException{
		Collection<AccountType> accountTypes =  this.bankService.findAccountTypes();
		for(AccountType accType: accountTypes){
			if(accType.getName().equalsIgnoreCase(text))
				return accType;
		}
		throw new ParseException("type not found: " + text, 0);
	}
}
