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
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cartId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="phoneNumber")
	private Customer customer;//one to one
	@OneToMany(mappedBy="cart",cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();// one to many
	private double totalAmount;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="couponId")
	private Coupon coupon;// one to one
	
	
	public Cart() {
		super();
	}
	public Cart(Customer customer, List<Product> products, double totalAmount, Coupon coupon) {
		super();
		this.customer = customer;
		this.products = products;
		this.totalAmount = totalAmount;
		this.coupon = coupon;
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
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
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
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}
	
	
}
