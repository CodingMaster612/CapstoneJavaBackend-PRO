package com.backend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Entity.Cart;
import com.backend.Entity.CreditCard;
import com.backend.Entity.Currency;
import com.backend.Entity.User;
import com.backend.Service.CartService;
import com.backend.Service.CurrencyService;
import com.backend.Service.UserService;

@RestController

@CrossOrigin(origins="*")
@RequestMapping(value="/cart")
public class CartRestController {
	@Autowired
	CartService cartService;
	 
	 @Autowired
	 UserService userService;
	 @RequestMapping(
	         value="/addToCart",
	         
	         produces = MediaType.APPLICATION_JSON_VALUE,
	        
	         method = RequestMethod.POST
	     )                                 
	     public ResponseEntity<Object> addToCart(@RequestBody Cart cart ) {

	         try {

	             Cart addToCart= cartService.save(cart);
	             

	             return new ResponseEntity<>(addToCart, HttpStatus.OK);

	         } catch(Exception e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	         } catch(Error e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	         }
	 
	}
	 
	 @RequestMapping(
	         value="/viewAllCart",
	         
	         produces = MediaType.APPLICATION_JSON_VALUE,
	        
	         method = RequestMethod.GET
	     )                                 
	     public ResponseEntity<Object> viewAllCart() {

	         try {

	             
	             List<Cart> getCart = cartService.viewAllCart();

	             return new ResponseEntity<>(getCart, HttpStatus.OK);

	         } catch(Exception e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	         } catch(Error e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	         }
	 
	}
	 
	 
	 @RequestMapping(value = "/CurrencyTransaction/{Id}",
	         consumes = MediaType.APPLICATION_JSON_VALUE,
	         produces = MediaType.APPLICATION_JSON_VALUE,
	         method = RequestMethod.POST
	         )
	 public ResponseEntity<Object> transactionsById(@RequestBody Cart cart, @PathVariable Integer Id ) {

	     try {
	    	 Integer CartId = cart.getId();
	    	 
	    	 User purchase = userService.CurrencyTransaction(CartId,Id);
	    	 
	         
	         if(purchase == null) {
	             
	             throw new Error("Invalid purchase");
	             
	         }
	 
	         return new ResponseEntity<>(purchase, HttpStatus.OK);
	         
	     } catch(Exception e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     } catch(Error e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }
	 
	 @RequestMapping(
		        value="/getCartById/{cartId}",
		        produces = MediaType.APPLICATION_JSON_VALUE,
		        method = RequestMethod.GET
		    )
		    public ResponseEntity<Object> getCartById(@PathVariable Integer cartId) {

		        try {

		            Cart cart= cartService.findCartById(cartId);
		       
		            return new ResponseEntity<>(cart, HttpStatus.OK);
		        } catch(Exception e) {
		            System.out.println(e.getMessage());
		            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		        } catch(Error e) {
		            System.out.println(e.getMessage());
		            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		        }

		    }
	 @RequestMapping(
			    value="/deleteCartItemsById/{Id}",
			    produces = MediaType.APPLICATION_JSON_VALUE,
			    method = RequestMethod.DELETE
			)
			public ResponseEntity<Object> deleteById(@PathVariable Integer Id) {

			    try {

			        cartService.deleteCartById(Id);

			        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			    } catch(Exception e) {
			        System.out.println(e.getMessage());
			        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
			    } catch(Error e) {
			        System.out.println(e.getMessage());
			        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
			    }
			}
	 
	 @RequestMapping(
	         value="/viewAllOwned/{email}",
	         
	         produces = MediaType.APPLICATION_JSON_VALUE,
	        
	         method = RequestMethod.GET
	     )                                 
	     public ResponseEntity<Object> viewOwned( @PathVariable String email) {

	         try {

	        	 List<Cart> BoughtCurrency = userService.getUserByEmail(email).getBoughtCurrency();
	             

	             return new ResponseEntity<>(BoughtCurrency, HttpStatus.OK);

	         } catch(Exception e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	         } catch(Error e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	         }
	 
	}
	 
	 
	 
}
