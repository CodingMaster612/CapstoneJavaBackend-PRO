package com.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Bank;
import com.backend.Entity.User;
import com.backend.Repo.BankRepo;
import com.backend.Repo.UserRepo;
@Service
public class BankService {
	 
	
	@Autowired
	BankRepo bankRepo;
	
	
	public Bank signIn(Bank bank) {
	        
	       
	        return bankRepo.signIn(bank.getEmail(), bank.getPassword());

	       
	    }



}
