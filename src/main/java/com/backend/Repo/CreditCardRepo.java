package com.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.Entity.CreditCard;


@Repository         
public interface CreditCardRepo extends JpaRepository<CreditCard, Integer>{
    
	
    
    
} 
