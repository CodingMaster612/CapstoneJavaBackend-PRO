package com.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Cart;
import com.backend.Entity.CreditCard;
import com.backend.Entity.User;
import com.backend.Repo.CreditCardRepo;
import com.backend.Repo.UserRepo;
@Service
public class CreditCardService {
	@Autowired
	CreditCardRepo creditCardRepo;
	
	
	
	@Autowired
UserRepo userRepo;
	public List<CreditCard> viewAllCreditCards() {
		
		return creditCardRepo.findAll();
	}
	public CreditCard findCardById(Integer creditCardId) {
		 return creditCardRepo.findById(creditCardId).get();
	}
	
	
}
