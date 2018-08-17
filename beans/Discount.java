package com.capgemini.store.beans;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Discount {
	
private Date startDateOfDiscount;
private Date endDateOfDiscount;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="productId")
private Product product;//one to one
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int discountId;
private int percentDiscount;
@ManyToOne
@JoinColumn(name="adminId")
private Admin admin;

public Discount() {
	super();
}
public Discount(Date startDateOfDiscount, Date endDateOfDiscount, Product product, int percentDiscount, Admin admin) {
	super();
	this.startDateOfDiscount = startDateOfDiscount;
	this.endDateOfDiscount = endDateOfDiscount;
	this.product = product;
	this.percentDiscount = percentDiscount;
	this.admin = admin;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public Date getStartDateOfDiscount() {
	return startDateOfDiscount;
}
public void setStartDateOfDiscount(Date startDateOfDiscount) {
	this.startDateOfDiscount = startDateOfDiscount;
}
public Date getEndDateOfDiscount() {
	return endDateOfDiscount;
}
public void setEndDateOfDiscount(Date endDateOfDiscount) {
	this.endDateOfDiscount = endDateOfDiscount;
}
public int getDiscountId() {
	return discountId;
}
public void setDiscountId(int discountId) {
	this.discountId = discountId;
}
public double getPercentDiscount() {
	return percentDiscount;
}
public void setPercentDiscount(int percentDiscount) {
	this.percentDiscount = percentDiscount;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + discountId;
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
	Discount other = (Discount) obj;
	if (discountId != other.discountId)
		return false;
	return true;
}



}
