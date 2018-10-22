package com.mrk.bankacc.web;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.mrk.bankacc.model.Account;
import com.mrk.bankacc.model.AccountType;
import com.mrk.bankacc.model.Customer;
import com.mrk.bankacc.service.BankService;

@Controller
@SessionAttributes("account")
public class AccountController {
	
	private final BankService bankService;
	
	@Autowired
	public AccountController(BankService bankService){
		this.bankService = bankService;
	}
	
    @ModelAttribute("types")
    public Collection<AccountType> populatePetTypes() {
        return this.bankService.findAccountTypes();
    }
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
    
    @RequestMapping(value = "/customer/{customerId}/account/new", method = RequestMethod.GET)
    public String initCreationForm(@PathVariable("customerId") int customerId, Map<String, Object> model) {
        Customer customer = this.bankService.findCustomerById(customerId); 
        Account account = new Account();
        customer.addAccount(account);
        model.put("account", account);
        return "account/createOrUpdateAccountForm";
    }
    
    @RequestMapping(value = "/customer/{customerId}/account/new", method = RequestMethod.POST)
    public String processCreationForm(@ModelAttribute("account") Account account, BindingResult result, SessionStatus status) {
        new AccountValidator().validate(account, result);
        if (result.hasErrors()) {
            return "account/createOrUpdateAccountForm";
        } else {
            this.bankService.saveAccount(account);
            status.setComplete();
            return "redirect:/customer/{customerId}";
        }
    }
    
}
