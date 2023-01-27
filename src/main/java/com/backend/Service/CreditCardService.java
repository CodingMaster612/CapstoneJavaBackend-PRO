package com.backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.CreditCard;
import com.backend.Repo.CreditCardRepo;
@Service
public class CreditCardService {
	@Autowired
	CreditCardRepo creditCardRepo;
	public List<CreditCard> viewAllCreditCards() {
		
		return creditCardRepo.findAll();
	}

}
