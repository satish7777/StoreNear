package com.meda.order.orderserivice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meda.order.orderserivice.entities.Order;
import com.meda.order.orderserivice.exception.OrderNotFoundException;
import com.meda.order.orderserivice.exception.OrderServiceException;
import com.meda.order.orderserivice.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {
	
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(path="/GetAllOrders",method=RequestMethod.GET)
	public List<Order> getAllOrders()  throws OrderNotFoundException,OrderServiceException
	{
		
		return orderService.findAllOrders();
	}

	@GetMapping(path="/getOrder/{orderName}")
	public Order getOrder(@PathVariable("orderName") final String orderName)  throws OrderNotFoundException,OrderServiceException
	{
		
		return orderService.getOrderByOrderName(orderName);
	}

	@RequestMapping(path="/AddOrder",method=RequestMethod.POST)
	public Order createOrder(@RequestBody Order order)  throws OrderServiceException,Exception
	{
		
		return orderService.createOrder(order);
	}

	@RequestMapping(path="/UpdateOrder/{orderId}",method=RequestMethod.POST)
	public Order updateOrder(@RequestBody Order order,@PathVariable("orderId") final Long orderId) throws OrderNotFoundException,OrderServiceException
	{ 
		
		return orderService.updateOrderByOrderId(order,orderId);
	}
	
	@PutMapping(path="/deleteOrder/{orderName}")
	public List<Order> deleteOrder(@PathVariable("orderName") final String orderName)  throws OrderNotFoundException,OrderServiceException
	{
		
		return orderService.deleteOrder(orderName);
	}
	
	
	
}
