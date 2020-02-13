package com.meda.order.orderserivice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meda.order.orderserivice.entities.CustomerOrder;
import com.meda.order.orderserivice.entities.Order;
import com.meda.order.orderserivice.entities.OrderItems;
import com.meda.order.orderserivice.exception.OrderNotFoundException;
import com.meda.order.orderserivice.exception.OrderServiceException;
import com.meda.order.orderserivice.respository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	
	
	public Order createOrder(Order order)  throws OrderServiceException,Exception
	{
		try {
		orderRepository.save(order);
		return orderRepository.getOne(order.getOrderId());
			
		}catch(Exception e) {
			
			throw new Exception("Exception occured while creating the order" ,e);
			
		}
	 }


	




	public List<Order> findAllOrders()  throws OrderServiceException
	{ 
		try {
		return orderRepository.findAll();
	  }catch(Exception e) {
		
		throw new OrderServiceException("Exception occured while fetching the Orders" ,e);
		
	}
	}



	public Order getOrderByOrderName(String orderName)  throws OrderNotFoundException,OrderServiceException
	 {
		try {
		return orderRepository.findByOrderName(orderName);
	 }catch(OrderNotFoundException e) {
			
			throw new OrderNotFoundException("Order Doesn't Exists" ,e);
			
		}catch(Exception use) {
			throw new OrderServiceException("Exception occured while fetching the Order" ,use);
		}
	}


	public Order updateOrderByOrderId(Order order, Long orderId)  throws OrderNotFoundException,OrderServiceException
	{
		try {
		Order update = getOrderByOrderId(orderId);
		
		if(update!=null) {
			     
			      update.setDeliveryStatus(order.getDeliveryStatus());
			      update.setOrderName(order.getOrderName());
			      update.setTotalMoney(order.getTotalMoney());
			      update.setOrderDate(order.getOrderDate());
			      
			     
			        if(update.getOrderItems()!=null) {
			        	
			            List<OrderItems> it = update.getOrderItems();
			            
			                 it.forEach( orderitem -> {
			                	 
			                	 for(int i=0 ;i < order.getOrderItems().size() ;i ++)
			                	
			                	 if(order.getOrderItems()!=null ) {
			                		 OrderItems newupdate = order.getOrderItems().get(i);
			                		 
			                		 if(newupdate.getProductName().equalsIgnoreCase(orderitem.getProductName())) {
			                		 
			                	      orderitem.setDescription(newupdate.getDescription());
			                	
			                		 }
			                	
			                	 }
			                 });
			        }
			        
			        if(update.getCorder()!=null) {
			        CustomerOrder co =	order.getCorder();
			        CustomerOrder cupdate = update.getCorder();
			        	cupdate.setComments(co.getComments());
			        	cupdate.setShipmentDate(co.getShipmentDate());
			        	cupdate.setShippedVia(co.getShippedVia());
			        	cupdate.setRequiredDate(co.getRequiredDate());
			        //	update.setCorder(cupdate);
			        }
			        
			      
				/*
				 * update.setLocation(order.getLocation());
				 * update.setPassword(order.getPassword()); update.setStatus(order.getStatus());
				 * update.setRoles(order.getRole());
				 */
		orderRepository.save(update);
		return getOrderByOrderId(orderId);
		}else {
			throw new OrderNotFoundException("Order Doesn't exists");
		}
	}catch(OrderNotFoundException e) {
		//e.printStackTrace();
		
		throw e;
	}catch(Exception e) {
		throw new OrderServiceException("Exception occured while updating the Order::"+e.getMessage() );
	}
	}

	public Order getOrderByOrderId(long orderId) throws OrderNotFoundException,OrderServiceException
	{
		return orderRepository.findOrderByOrderId(orderId);
	}

	public List<Order> deleteOrder(String orderName)  throws OrderNotFoundException,OrderServiceException
	 {
		try {
		Order order = getOrderByOrderName(orderName);
		if(order!=null) {
		orderRepository.delete(order);
		return findAllOrders();
		
	 }else {
			throw new OrderNotFoundException("Order Doesn't exists");
		}
	}catch(OrderNotFoundException e) {
		//e.printStackTrace();
		throw e;
	}catch(OrderServiceException e) {
		
		throw new OrderServiceException("Exception occured while deleting the Order" ,e);
		
	}catch(Exception e) {
		
		throw new OrderServiceException("Exception occured while deleting the Order"+e.getMessage());
		
	}
		
	}

}
