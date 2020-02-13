package com.meda.order.orderserivice.respository;

import org.springframework.stereotype.Repository;

import com.meda.order.orderserivice.entities.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

	Order findOrderByOrderId(long orderId);

	Order findByOrderName(String orderName);
	

}
