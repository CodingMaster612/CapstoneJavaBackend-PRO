package com.backend.Entity;



import java.util.List;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="currency")
public class Currency {

	
	
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Integer id;
	
	
	
	
	
	
	@Column(name="images")
	 private String image;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	
	 private User user;
	
	
	
	private Integer amount;
	
	
	 private String currency;
	
	
	 


	public Currency() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Currency(Integer id, String image, User user, Integer amount, String currency) {
		super();
		this.id = id;
		this.image = image;
		this.user = user;
		this.amount = amount;
		this.currency = currency;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getImage() {
		return image;
	}





	public void setImage(String image) {
		this.image = image;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public Integer getAmount() {
		return amount;
	}





	public void setAmount(Integer amount) {
		this.amount = amount;
	}





	public String getCurrency() {
		return currency;
	}





	public void setCurrency(String currency) {
		this.currency = currency;
	}





	@Override
	public String toString() {
		return "Currency [id=" + id + ", image=" + image + ", user=" + user + ", amount=" + amount + ", currency="
				+ currency + "]";
	}











	










	






	







	
	
	
}
