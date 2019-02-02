package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;

@RestController
@RequestMapping("/account")
public class HomeRestService {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@RequestMapping(value="/create", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON)
	public HttpStatus createAccount(@RequestBody Account account) {
		
		Account acc= new Account();
		acc.setFirst_name(account.getFirst_name());
		acc.setLast_name(account.getLast_name());
		acc.setId_proof(account.getId_proof());
		Account a = accountRepository.save(acc);
		
		HttpStatus httpStatus ;
		if(a !=null) {
			httpStatus = HttpStatus.CREATED;
		}else {
			httpStatus = HttpStatus.EXPECTATION_FAILED;
		}
		return httpStatus;
	}
	
	@RequestMapping(value="/getAccount/{accId}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public Account getAccount(@PathVariable("accId") Long accId) {
		return accountRepository.getOne(accId);
	}
	
	
	@RequestMapping(value="/getAllAccounts", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public List<Account> getAccount() {
		return accountRepository.findAll();
	}
	@RequestMapping(value="/home", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON)
	public String getHome() {
		return "home";
	}

}
