package com.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Admin;
import com.backend.Entity.User;
import com.backend.Repo.AdminRepo;
import com.backend.Repo.UserRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminRepo;
	
	@Autowired 
	UserRepo userRepo;
	
	
	public Admin signIn(Admin admin) {
        
	       
        return adminRepo.AdminSignIn(admin.getEmail(), admin.getPassword());

       
    }
	
	

}

