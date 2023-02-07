package com.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.backend.Entity.Cart;




@Repository         
public interface CartRepo extends JpaRepository<Cart, Integer>{
	
	
    
    
} 
