package com.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.Entity.Admin;
import com.backend.Repo.AdminRepo;

@Service
public class AdminService {
	
	@Autowired
	AdminRepo adminRepo;
	
	
	
	public Admin signIn(Admin admin) {
        
	       
        return adminRepo.AdminSignIn(admin.getEmail(), admin.getPassword());

       
    }
}
