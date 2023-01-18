package com.backend.Entity;



import java.util.List;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency {

	
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer id;
	
	
	@Column(name="crypto")
	 String crypto;
	
	@Column(name="currency")
	Integer currency;
	
	
	@Column(name="cost")
	 Integer cost;
	
	@Column(name="payment")
	 Integer payment;
	
	@Column(name="images")
	 String image;
	
	
	
	
	


	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}







	public Currency(Integer id, String crypto, Integer currency, Integer cost, Integer payment, String image) {
		super();
		this.id = id;
		this.crypto = crypto;
		this.currency = currency;
		this.cost = cost;
		this.payment = payment;
		this.image = image;
	}







	public Integer getId() {
		return id;
	}







	public void setId(Integer id) {
		this.id = id;
	}







	public String getCrypto() {
		return crypto;
	}







	public void setCrypto(String crypto) {
		this.crypto = crypto;
	}







	public Integer getCurrency() {
		return currency;
	}







	public void setCurrency(Integer currency) {
		this.currency = currency;
	}







	public Integer getCost() {
		return cost;
	}







	public void setCost(Integer cost) {
		this.cost = cost;
	}







	public Integer getPayment() {
		return payment;
	}







	public void setPayment(Integer payment) {
		this.payment = payment;
	}







	public String getImage() {
		return image;
	}







	public void setImage(String image) {
		this.image = image;
	}







	@Override
	public String toString() {
		return "Currency [id=" + id + ", crypto=" + crypto + ", currency=" + currency + ", cost=" + cost + ", payment="
				+ payment + ", image=" + image + "]";
	}

	

	
	
	
	
}
