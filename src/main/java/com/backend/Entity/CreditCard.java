package com.backend.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creditcard")
public class CreditCard {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer id;
	
	
	@Column(name="firstNumbers")
	private Integer firstNumbers;
	
	@Column(name="secondNumbers")
	private Integer secondNumbers;
	
	
	@Column(name="thirdNumbers")
	private Integer thirdNumbers;
	
	@Column(name="fourthNumbers")
	private Integer fourthNumbers;
	
	@Column(name="cardName")
	private String name;
	
	@Column(name="cardHolder")
	private String holder;
	
	@Column(name="image")
	private String image;
	

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public CreditCard(Integer id, Integer firstNumbers, Integer secondNumbers, Integer thirdNumbers,
			Integer fourthNumbers, String name, String holder, String image) {
		super();
		this.id = id;
		this.firstNumbers = firstNumbers;
		this.secondNumbers = secondNumbers;
		this.thirdNumbers = thirdNumbers;
		this.fourthNumbers = fourthNumbers;
		this.name = name;
		this.holder = holder;
		this.image = image;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFirstNumbers() {
		return firstNumbers;
	}

	public void setFirstNumbers(Integer firstNumbers) {
		this.firstNumbers = firstNumbers;
	}

	public Integer getSecondNumbers() {
		return secondNumbers;
	}

	public void setSecondNumbers(Integer secondNumbers) {
		this.secondNumbers = secondNumbers;
	}

	public Integer getThirdNumbers() {
		return thirdNumbers;
	}

	public void setThirdNumbers(Integer thirdNumbers) {
		this.thirdNumbers = thirdNumbers;
	}

	public Integer getFourthNumbers() {
		return fourthNumbers;
	}

	public void setFourthNumbers(Integer fourthNumbers) {
		this.fourthNumbers = fourthNumbers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", firstNumbers=" + firstNumbers + ", secondNumbers=" + secondNumbers
				+ ", thirdNumbers=" + thirdNumbers + ", fourthNumbers=" + fourthNumbers + ", name=" + name + ", holder="
				+ holder + ", image=" + image + "]";
	}

	
	
	
	
}
