package com.mrk.bankacc.web;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import com.mrk.bankacc.model.Account;

public class AccountValidator {

	public void validate(Account account, Errors errors ){
		
		if(!StringUtils.hasLength(account.getAccNumber()))
			errors.rejectValue("AccNumber", "required", "required");
		else if(account.isNew() && account.getCustomer().getAccount(account.getAccNumber(), true) != null)
			 errors.rejectValue("AccNumber", "duplicate", "already exists");
		if(account.getAccType() == null)
			errors.rejectValue("AccType", "required", "required");
		if(account.getAccCreationDate() == null)
			errors.rejectValue("AccCreationDate", "required", "required");
	}
	
}
