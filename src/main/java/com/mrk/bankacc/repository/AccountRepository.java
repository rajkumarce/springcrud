package com.mrk.bankacc.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.mrk.bankacc.model.Account;
import com.mrk.bankacc.model.AccountType;

public interface AccountRepository {
	
	public List<AccountType> findAccountTypes();
	
	void save(Account account) throws DataAccessException;
	

}
