package com.backend.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Cart;
import com.backend.Entity.Currency;
import com.backend.Entity.User;
import com.backend.Repo.CartRepo;

@Service
public class CartService {
	
	@Autowired
    CartRepo cartRepo;
	public Cart save(Cart cart) {
		
	    return cartRepo.save(cart);
	}
	
	
	public List<Cart> viewAllCart() {
        return cartRepo.findAll();
    }


	public Cart findCartById(Integer cartId) {

        return cartRepo.findById(cartId).get();

    }
	
	 public void deleteCartById(Integer id) {

	        cartRepo.deleteById(id);
	        
	    }

	 public Cart saveConvertedAmount(Double convertedAmount) {

		 	Cart cart = new Cart();
		    cart.setConvertedAmount(convertedAmount);
		    return cartRepo.save(cart);
		 
		 
	 
	 }
	
}
