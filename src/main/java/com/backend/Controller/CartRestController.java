package com.backend.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Entity.Cart;
import com.backend.Entity.Currency;
import com.backend.Service.CartService;
import com.backend.Service.CurrencyService;

@RestController

@CrossOrigin(origins="*")
@RequestMapping(value="/cart")
public class CartRestController {
	@Autowired
	CartService cartService;
	 
	 
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
}
