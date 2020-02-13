package com.meda.customer.customerservice.entities;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	@Column(name = "customer_Id")
	private  long customerId;
	private String firstName;
	private String lastName;
	private long mobileNumber;
	private String eMailId;
	private String status;
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	// @JoinColumn(name="customer_Id",referencedColumnName="customer_Id" ,nullable =
	// false)
	private List<Address> address;

	
	public Customer() {
		
	}

	public Customer(long customerId, String firstname, String lastName, long mobileNumber, String eMailId, String status,
			List<Address> address) {

		this.customerId = customerId;
		this.firstName = firstname;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.eMailId = eMailId;
		this.status = status;
		this.address = address;
		 if(address!=null) {
			  
			  this.address.forEach(x -> x.setCustomer(this)); }
        
		
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
		
		  if(address!=null) {
		  
		  this.address.forEach(x -> x.setCustomer(this)); }
		 
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String geteMailId() {
		return eMailId;
	}

	public void seteMailId(String eMailId) {
		this.eMailId = eMailId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
