package com.backend.Repo;







import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.Entity.Currency;



@Repository         
public interface CurrencyRepo extends JpaRepository<Currency, Integer>{

	
    
	
    
    
} 
