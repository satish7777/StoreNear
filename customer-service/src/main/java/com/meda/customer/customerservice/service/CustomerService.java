package com.meda.customer.customerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.meda.customer.customerservice.repository.CustomerRepository;
import com.meda.customer.customerservice.entities.Address;
import com.meda.customer.customerservice.entities.Customer;
import com.meda.customer.customerservice.exception.CustomerNotFoundException;
import com.meda.customer.customerservice.exception.CustomerServiceException;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public List<Customer> getAllCustomers() throws CustomerServiceException {
		List<Customer> custList = new ArrayList<Customer>();
		try {
			custList = customerRepository.findAll();
			if(custList.isEmpty()) {
				throw new CustomerServiceException("No Single Customer Exists"); 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return customerRepository.findAll();

	}

	public Optional<Customer> getonecustomer(int id) throws CustomerNotFoundException ,Exception {
		try {
			Optional<Customer> cust = customerRepository.findById(id);
			if (!cust.isPresent()) {
				throw new CustomerNotFoundException("Customer does not  Exists " + id);
			}
			
			return customerRepository.findById(id);
		}catch(Exception e) {
			throw new Exception(" Error occured while fetching the customer id " + id + " is " ,e);
		}
		
		
	}

	public Customer updateCustomer(long id, Customer customer)  throws CustomerNotFoundException,CustomerServiceException{
		
		try {
			Customer update = getCustomerByCustomerId(id);
			
			if (update!=null) {
				
				if (update.geteMailId().equalsIgnoreCase(customer.geteMailId())){
					
					update.setFirstName(customer.getFirstName());
					
					update.setLastName(customer.getLastName());
					
					update.setMobileNumber(customer.getMobileNumber());
					
					update.setStatus(customer.getStatus());
					
					 if(update.getAddress()!=null) {
						 
						 List<Address> addrList = update.getAddress();
						 List<Address> updaddrList = customer.getAddress();
						
						 
						
							 
							 if(addrList!=null && addrList.size() > 0&& updaddrList!=null && updaddrList.size() > 0) {
								 addrList.forEach( addr -> {
	 
		                	 for(int i=0 ;i < updaddrList.size() ;i ++) 
		                	 {
		                	
		                		 Address newupdate = updaddrList.get(i);
		                		 System.out.println(" new  ---> " + addr.getAddressId() + " old --> " + newupdate.getAddressId() );
		                		 if(newupdate.getAddressId() == addr.getAddressId()) {
		                			 addr.setAddress1(newupdate.getAddress1());
		                			 addr.setAddress2(newupdate.getAddress2());
									} /*
										 * else if(newupdate.getAddressId() == 0){ addrList.add(newupdate); }
										 */
		                		 /*
										 * else { addrList.add(newupdate); }
										 */
		               	 }
		                	 
							 });
		        		 }
						 
						 
					 }
				}
				
				 customerRepository.save(update);
				 
				 return getCustomerByCustomerId(update.getCustomerId());
			}else {
			
				throw new CustomerNotFoundException("Customer does not  Exists " + id);
			}
			
			
			
		
		}catch (CustomerNotFoundException e) {
			throw e;
		}catch(Exception e) {
			e.printStackTrace();
			throw new CustomerServiceException("Exception occured while updating the Customer::"+e.getMessage() );
		}
		
		
	}

	private Customer getCustomerByCustomerId(long id) throws CustomerServiceException,Exception {
		
		return customerRepository.getCustomerByCustomerId(id);
	}

	public Customer createCustomer(Customer customer)  throws CustomerServiceException,Exception{
		try {
			Customer cust = getCustomerByCustomerId(customer.getCustomerId());
			if (cust!=null) {
				throw new CustomerServiceException("Customer Already Exists" + customer.getCustomerId());
			}
			
			return customerRepository.save(customer); 
			
		} catch (Exception e) {
			throw new Exception("Exception occured while creating the order" ,e);
		}
		
	}

	public HttpStatus deleteCustomer(int id) {

		Optional<Customer> cust = customerRepository.findById(id);
		try {
			if (!cust.isPresent()) {
				throw new CustomerNotFoundException("Customer does not Exists "+ id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
		customerRepository.deleteById(id);
		return HttpStatus.OK;
	}

}
