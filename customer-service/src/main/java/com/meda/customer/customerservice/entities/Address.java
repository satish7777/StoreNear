package com.meda.customer.customerservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private long addressId;
	// @ManyToOne(fetch=FetchType.LAZY)
	
//	private long customerId;
	private String address1;
	private String address2;
	// private String LandMark;
	// private String City;
	// private Long phoneNumber;
	// private long postalCode;
	// private String State;
	// private String country;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "fkcustomer_Id")
	 private Customer customer;
	
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	/*
	 * public long getCutomerId() { return customerId; }
	 * 
	 * public void setCutomerId(int cutomerId) { this.customerId = cutomerId; }
	 */

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
	  public Customer getCustomer() { return customer; } 
	  public void setCustomer(Customer customer) { this.customer = customer; }
	 

}
