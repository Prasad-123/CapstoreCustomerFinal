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
public class Inventory {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int inventoryId;
	@OneToMany(mappedBy="inventory",cascade=CascadeType.ALL)
	private List<Product> products = new ArrayList<Product>();// one to many
	@OneToMany(mappedBy="inventory",cascade=CascadeType.ALL)
	private List<Category> category = new ArrayList<Category>();//one to many
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="merchantId")
	private Merchant merchant;//one to one
	
	
	public Inventory() {
		super();
	}
	public Inventory(List<Product> products, List<Category> category, Merchant merchant) {
		super();
		this.products = products;
		this.category = category;
		this.merchant = merchant;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<Category> getCategory() {
		return category;
	}
	public void setCategory(List<Category> category) {
		this.category = category;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + inventoryId;
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
		Inventory other = (Inventory) obj;
		if (inventoryId != other.inventoryId)
			return false;
		return true;
	}
	
	
}
