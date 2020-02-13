package com.meda.customer.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meda.customer.customerservice.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	Customer getCustomerByCustomerId(long id);

}
