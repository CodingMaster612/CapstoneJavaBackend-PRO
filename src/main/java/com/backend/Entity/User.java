package com.backend.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Annotate Objects with Entity, lets project know its a Object from the DB
@Entity
// Tells what table the object is coming from
@Table(name="user")
public class User {
	
	// ID lets you know its an id
    @Id
    // Column maps to the same name as the column name in the database, it is case sensitive
    @Column(name = "id")
    // This will configure your id to be auto generated, now you don't need a setter for your id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
    
    // you can also give unique or nullable as args to Column, to toggle those attributes
    @Column(name="email", unique = true, nullable = false)
	String email;
    @Column(name="username")
	String username;
    @Column(name="password", nullable = false)
	String password;
    
    @Column (name="storedUrl")
    String storedUrl;
    
   @OneToMany
   @JoinColumn(name="Transactions_id", referencedColumnName = "id")
   List<CreditCard> Transations;
   
   @OneToMany
   @JoinColumn(name="Bought_id", referencedColumnName = "id")
   List<Cart> BoughtCurrency;
   
   
   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name="ConvertedAmount_id", referencedColumnName = "id")
   private Cart cart;


public User() {
	super();
	// TODO Auto-generated constructor stub
}


public User(Integer id, String email, String username, String password, String storedUrl, List<CreditCard> transations,
		List<Cart> boughtCurrency, Cart cart) {
	super();
	this.id = id;
	this.email = email;
	this.username = username;
	this.password = password;
	this.storedUrl = storedUrl;
	Transations = transations;
	BoughtCurrency = boughtCurrency;
	this.cart = cart;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getStoredUrl() {
	return storedUrl;
}


public void setStoredUrl(String storedUrl) {
	this.storedUrl = storedUrl;
}


public List<CreditCard> getTransations() {
	return Transations;
}


public void setTransations(List<CreditCard> transations) {
	Transations = transations;
}


public List<Cart> getBoughtCurrency() {
	return BoughtCurrency;
}


public void setBoughtCurrency(List<Cart> boughtCurrency) {
	BoughtCurrency = boughtCurrency;
}


public Cart getCart() {
	return cart;
}


public void setCart(Cart cart) {
	this.cart = cart;
}


@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", username=" + username + ", password=" + password + ", storedUrl="
			+ storedUrl + ", Transations=" + Transations + ", BoughtCurrency=" + BoughtCurrency + ", cart=" + cart
			+ "]";
}


}