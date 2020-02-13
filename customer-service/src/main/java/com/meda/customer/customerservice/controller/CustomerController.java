package com.meda.customer.customerservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meda.customer.customerservice.service.CustomerService;
import com.meda.customer.customerservice.entities.Customer;
import com.meda.customer.customerservice.exception.CustomerNotFoundException;
import com.meda.customer.customerservice.exception.CustomerServiceException;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerrService;
	

	@GetMapping("/getAllCustomers")
	public List<Customer> getAllCustomers() throws CustomerServiceException{
		
		return customerrService.getAllCustomers();
	}
	
	@GetMapping("/getcustbyID/{id}")
	public Optional<Customer> getoneCustomer(@PathVariable int id) throws CustomerNotFoundException, Exception {
		return customerrService.getonecustomer(id);
	}
	
	@PutMapping("/updateCustomer/{id}")
	public Customer updateCustomer(@PathVariable long id,@RequestBody Customer customer) throws CustomerNotFoundException, CustomerServiceException {
			
		return customerrService.updateCustomer(id, customer);
	}
	
	@PostMapping("/createCustomer")
	public Customer createCustomer(@RequestBody Customer customer) throws CustomerServiceException, Exception {
		return customerrService.createCustomer(customer);
	}
	
	@DeleteMapping("/deleteCustomer/{id}")
	public HttpStatus deleteCustomer(@PathVariable int id) {
		return customerrService.deleteCustomer(id);
		
	}
}
