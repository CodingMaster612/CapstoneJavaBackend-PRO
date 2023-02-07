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
	
	@Column(name="convertedAmount")
	Double convertedAmount;

	@Column(name="image")
	String image;
	
	@OneToOne(mappedBy= "cart")
	  
	   private User user;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}




	




	public Cart(Integer id, String currency, Integer amount, Double convertedAmount, String image) {
		super();
		this.id = id;
		this.currency = currency;
		this.amount = amount;
		this.convertedAmount = convertedAmount;
		this.image = image;
	}









	public String getImage() {
		return image;
	}









	public void setImage(String image) {
		this.image = image;
	}









	




	public Double getConvertedAmount() {
		return convertedAmount;
	}









	public void setConvertedAmount(Double convertedAmount) {
		this.convertedAmount = convertedAmount;
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
		return "Cart [id=" + id + ", currency=" + currency + ", amount=" + amount + ", convertedAmount="
				+ convertedAmount + ", image=" + image + "]";
	}














	









	
	
	
	
}
	
	
	
