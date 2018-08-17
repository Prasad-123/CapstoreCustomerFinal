package com.capgemini.store.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int categoryId;
@OneToMany(mappedBy="category",cascade=CascadeType.ALL)
private List<Product> products = new ArrayList<Product>();// one to many
private String categoryName;//Clothes, books, gadgets
private String type;		// shirts, pants, dresses in clothing
@ManyToOne
@JoinColumn(name="inventoryId")
private Inventory inventory;


public Category() {
	super();
}

public Category(List<Product> products, String categoryName, String type, Inventory inventory) {
	super();
	this.products = products;
	this.categoryName = categoryName;
	this.type = type;
	this.inventory = inventory;
}

public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}
public Inventory getInventory() {
	return inventory;
}
public void setInventory(Inventory inventory) {
	this.inventory = inventory;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + categoryId;
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
	Category other = (Category) obj;
	if (categoryId != other.categoryId)
		return false;
	return true;
}


}
