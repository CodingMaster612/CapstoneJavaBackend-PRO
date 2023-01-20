package com.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {

	
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer id;
	
	
	@Column(name="currency")
	 String currency;
	
	@Column(name="amount")
	Integer amount;

	
	
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Cart(Integer id, String currency, Integer amount) {
		super();
		this.id = id;
		this.currency = currency;
		this.amount = amount;
	}




	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public String getCurrency() {
		return currency;
	}




	public void setCurrency(String currency) {
		this.currency = currency;
	}




	public Integer getAmount() {
		return amount;
	}




	public void setAmount(Integer amount) {
		this.amount = amount;
	}




	@Override
	public String toString() {
		return "Cart [id=" + id + ", currency=" + currency + ", amount=" + amount + "]";
	}









	
	
	
	
}
	
	
	
