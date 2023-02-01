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

import com.backend.Entity.Admin;
import com.backend.Entity.User;
import com.backend.Service.AdminService;

@RestController

@CrossOrigin(origins="*")
@RequestMapping(value="/admin")
public class AdminRestController {
	
	@Autowired
	AdminService adminService;
	
	
	
	
	@RequestMapping(value = "/Admin",
	         consumes = MediaType.APPLICATION_JSON_VALUE,
	         produces = MediaType.APPLICATION_JSON_VALUE,
	         method = RequestMethod.POST
	         )
	 public ResponseEntity<Object> AdminSignIn(@RequestBody Admin admin) {

	     try {
	         Admin signedInAdmin = adminService.signIn(admin);
	         
	         if(signedInAdmin== null) {
	             
	             throw new Error("No Admin found");
	             
	         }
	 
	         return new ResponseEntity<>(signedInAdmin, HttpStatus.OK);
	         
	     } catch(Exception e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	     } catch(Error e) {
	         return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	     }
	 }
	 
}
