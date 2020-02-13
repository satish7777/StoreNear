package com.meda.order.orderserivice.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer_Order")
public class CustomerOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customerOrderId")
	private long customerOrderId;
	
    private long customerId;
    
    
    
    private long addressId;
    
    private Date requiredDate;
    
    private Date shipmentDate;
    
    private String shippedVia;
    
    private String comments;
    
    @JsonIgnore
     @OneToOne 
   @JoinColumn(name="fk_orderId") 
    private Order corder;
		 
	public Order getCorder() {
		return corder;
	}

	public void setCorder(Order corder) {
		this.corder = corder;
	}

	public long getCustomerOrderId() {
		return customerOrderId;
	}
	
	public void setCustomerOrderId(long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	
	public long getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}
	
	public long getAddressId() {
		return addressId;
	}
	
	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}
	
	public Date getRequiredDate() {
		return requiredDate;
	}
	
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	
	public Date getShipmentDate() {
		return shipmentDate;
	}
	
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}
	
	public String getShippedVia() {
		return shippedVia;
	}
	
	public void setShippedVia(String shippedVia) {
		this.shippedVia = shippedVia;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}


   
    
}
