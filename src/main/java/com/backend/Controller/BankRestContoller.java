package com.backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.backend.Entity.Bank;
import com.backend.Entity.User;
import com.backend.Service.BankService;
import com.backend.Service.UserService;
@RestController

@CrossOrigin(origins="*")
@RequestMapping(value="/bank")
public class BankRestContoller {
	
	
	
	
	@Autowired
	 BankService bankService;
	
	
	
	@RequestMapping(value = "/signIn",
	         consumes = MediaType.APPLICATION_JSON_VALUE,
	         produces = MediaType.APPLICATION_JSON_VALUE,
	         method = RequestMethod.POST
	         )
	 public ResponseEntity<Object> signIn(@RequestBody Bank bank) {

	     try {
	         Bank signedInBank = bankService.signIn(bank);
	         
	         if(signedInBank == null) {
	             
	             throw new Error("No user found");
	             
	         }
	 
	         return new ResponseEntity<>(signedInBank, HttpStatus.OK);
	         
	     } catch(Exception e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     } catch(Error e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }
}
