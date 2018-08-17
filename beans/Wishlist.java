package com.capgemini.store.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Wishlist {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int wishListId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="phoneNumber")
	private Customer customer;// one to one
	@OneToMany(mappedBy="wishlist",cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();// one to many
	
	
	public Wishlist() {
		super();
	}
	public Wishlist(Customer customer, List<Product> products) {
		super();
		this.customer = customer;
		this.products = products;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + wishListId;
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
		Wishlist other = (Wishlist) obj;
		if (wishListId != other.wishListId)
			return false;
		return true;
	}
	
	
	
}
