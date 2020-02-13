package com.meda.order.orderserivice.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderId")
	private long orderId;

	private String orderName;
	private double totalMoney;
	private Date orderDate;
	private String deliveryStatus;

	// @OneToMany(mappedBy ="order",cascade=CascadeType.ALL)
	// @OneToMany(joinColumn ="order",cascade=CascadeType.ALL)

	//@OneToMany(mappedBy = "order")
	 @OneToMany(mappedBy = "order",cascade=CascadeType.ALL)
	// @JoinColumn(name = "orderId")
	List<OrderItems> orderItems = new ArrayList<OrderItems>();

	
	  
	 @OneToOne(mappedBy ="corder",cascade=CascadeType.ALL) 
	  private CustomerOrder corder;
	 
	 public Order() {
		 
	 }
	 
	public CustomerOrder getCorder() {
		return corder;
	}

	public void setCorder(CustomerOrder corder) {
		this.corder = corder;
		if(corder!=null) 
			corder.setCorder(this);
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public List<OrderItems> getOrderItems() {
		return orderItems;
	}
    
	public void setOrderItems(List<OrderItems> orderItems) {
		this.orderItems = orderItems;
		if(orderItems!=null) {
			orderItems.forEach(x-> { 
				if (x!=null)
					x.setOrder(this);
			
			});
		}
		 
	}

}
