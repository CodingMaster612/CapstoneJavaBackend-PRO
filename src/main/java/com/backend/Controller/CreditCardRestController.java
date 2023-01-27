package com.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Entity.CreditCard;
import com.backend.Entity.Currency;
import com.backend.Service.CreditCardService;
import com.backend.Service.CurrencyService;

@RestController

@CrossOrigin(origins="*")
@RequestMapping(value="/card")
public class CreditCardRestController {

	
	@Autowired
	 CreditCardService creditCardService;
	 
	 
	 @RequestMapping(
	         value="/viewAllCreditCards",
	         
	         produces = MediaType.APPLICATION_JSON_VALUE,
	        
	         method = RequestMethod.GET
	     )                                 
	     public ResponseEntity<Object> viewAllCreditCards() {

	         try {

	             
	             List<CreditCard> getCreditCard = creditCardService.viewAllCreditCards();

	             return new ResponseEntity<>(getCreditCard, HttpStatus.OK);

	         } catch(Exception e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	         } catch(Error e) {
	             System.out.println(e.getMessage());
	             return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	         }
	 
	}
	 
	 
}
