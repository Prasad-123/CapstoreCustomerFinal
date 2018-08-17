package com.capgemini.store.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	@Id
	private String phoneNumber;
	// changed
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Address> address = new ArrayList<Address>();
	@Column(unique = true)
	private String email;
	private String password;
	private String cardNumber;
	private String securityQuestion;
	private String securityAnswer;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Review> reviews = new ArrayList<Review>();// one to many
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Orders> orders = new ArrayList<Orders>();// one to many
	private String customerName;

	
	public Customer() {
		super();
	}

	public Customer(List<Address> address, String email, String password, String cardNumber, String securityQuestion,
			String securityAnswer, List<Review> reviews, List<Orders> orders, String customerName) {
		super();
		this.address = address;
		this.email = email;
		this.password = password;
		this.cardNumber = cardNumber;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
		this.reviews = reviews;
		this.orders = orders;
		this.customerName = customerName;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		return true;
	}

	
}
