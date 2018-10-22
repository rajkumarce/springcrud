package com.mrk.bankacc.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.mrk.bankacc.repository.AccountRepository;
import com.mrk.bankacc.model.Account;
import com.mrk.bankacc.model.AccountType;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	
    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<AccountType> findAccountTypes() {
        return this.em.createQuery("SELECT atype FROM AccountType atype ORDER BY atype.name").getResultList();
    }
    
    @Override
    public void save(Account account) {
    	if (account.getAccNumber() == null) {
    		this.em.persist(account);     		
    	}
    	else {
    		this.em.merge(account);    
    	}
    }

}
