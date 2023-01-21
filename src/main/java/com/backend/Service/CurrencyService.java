package com.backend.Service;




import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Cart;
import com.backend.Entity.Currency;
import com.backend.Entity.User;
import com.backend.Repo.CartRepo;
import com.backend.Repo.CurrencyRepo;


@Service
public class CurrencyService {
	@Autowired
	CurrencyRepo currencyRepo;


    @Autowired 
    CartRepo cartRepo;
    
    public List<Currency> viewAllCurrency() {
        return currencyRepo.findAll();
    }
    
    
    public Currency findCurrencyById(Integer currencyId) {
		return currencyRepo.findById(currencyId).get();
	}


	public Cart findCartById(Integer cartId) {
		return cartRepo.findById(cartId).get();

		
	}
    
	

    
    
}
