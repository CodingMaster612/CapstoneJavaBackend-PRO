package com.backend.Service;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Currency;
import com.backend.Repo.CurrencyRepo;


@Service
public class CurrencyService {
	@Autowired
	CurrencyRepo currencyRepo;


    
    
    public List<Currency> viewAllCurrency() {
        return currencyRepo.findAll();
    }
    
    
    public Currency findCurrencyById(Integer amountId) {
		return currencyRepo.findById(amountId).get();
	}
    
	
   
    
    
    
}
