package com.backend.Service;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Cart;
import com.backend.Entity.Currency;

import com.backend.Entity.User;
import com.backend.Repo.UserRepo;

// This annotates the Class to be a Service bean 
// SERVICES ARE FOR HOLDING YOUR BUSINESS LOGIC, NOT THE CONTROLLER
// THE PROCESS TO DO ANYTHING IN YOUR CODE SHOULD BE DONE HERE
// DONT HAVE BIG UGLY SPAGHETTI CODE CONTROLLERS, DATS BAD
@Service
public class UserService {
	
   
    @Autowired
    UserRepo userRepo;
	
    @Autowired
    CurrencyService currencyService;
    
	public List<User> getAll() {
		
	    return userRepo.findAll();
	}
	
	public User save(User user) {
		
	    return userRepo.save(user);
	}
    
    public User signIn(User user) {
        
       
        return userRepo.signIn(user.getEmail(), user.getPassword());

       
    }
    
    public User getUserById(Integer userId) {
        
    	
    	
        if(userRepo.findById(userId).isPresent()) {
            return userRepo.findById(userId).get();
        }
        
        
        throw new Error("User not found");
        
    }
    
    public User getUserByEmail(String email) {
        
    	
        User foundUser = userRepo.getByEmail(email);
        
        if(foundUser == null) {
           throw new Error("User not found");
        }
        
        return foundUser;
        
    }
    
    public User updateUser(User user) throws Exception {

        if(user.getId() == null) {
            throw new Exception("error...");
        }
        return userRepo.save(user);
        
    }
    
    public void deleteUserById(Integer id) {

        userRepo.deleteById(id);
        
    }
    public User buyCurrency(Integer userId, Integer cartId) {

        User loggedInUser = findUserById(userId);

       Cart currency = currencyService.findCartById(cartId);

        loggedInUser.getBoughtCurrency().add(currency);

        return save(loggedInUser);
    }

	public User findUserById(Integer userId) {
        return userRepo.findById(userId).get();
    }
	
	public User buyCurrencyFromCart(Integer userId, Integer cartId) {

        User loggedInUser = findUserById(userId);

       Cart currency = currencyService.findCartById(cartId);

        loggedInUser.getBoughtCurrency().add(currency);

        return save(loggedInUser);
    }
	
	public User findByCartId(Integer cartId) {

        return userRepo.findById(cartId).get();

    }

	
	public User findById(Integer Id) {

        return userRepo.findById(Id).get();

    }
	

}
