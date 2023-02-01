package com.backend.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.Entity.Admin;



@Repository         // Between the <,> first put the type of object, next the type of the primary key
public interface AdminRepo extends JpaRepository<Admin, Integer>{
    
	// You make these to query your DB on non primary key columns
	// The ?1 is to represent the arguments in the function, first argument goes first, then second etc...
	// Annotate and give value= and nativeQuery=true so you can use easy SQL syntax
    @Query(value="select * from admin where email = ?1 && password=?2", nativeQuery=true)
    public Admin AdminSignIn(String email, String password);
    
    
}
