package com.meda.product.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meda.product.productservice.entities.Product;
import com.meda.product.productservice.exception.ProductNotFoundException;
import com.meda.product.productservice.exception.ProductServiceException;
import com.meda.product.productservice.service.ProductService;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	@Autowired
	ProductService productService;
	
	
	

	@RequestMapping(path="/GetAllProducts",method=RequestMethod.GET)
	public List<Product> getAllUsers()  throws ProductNotFoundException,ProductServiceException
	{
		
		return productService.findAllProductInfo();
	}

	@GetMapping(path="/getUser/{productName}")
	public Product getUser(@PathVariable("productName") final String productName)  throws ProductNotFoundException,ProductServiceException
	{
		
		return productService.getProductByProductName(productName);
	}

	@RequestMapping(path="/addProduct",method=RequestMethod.POST)
	public Product createUser(@RequestBody Product product)  throws ProductServiceException,Exception
	{
		
		return productService.createProduct(product);
	}

	@RequestMapping(path="/updateProduct/{productName}",method=RequestMethod.POST)
	public Product updateUser(@RequestBody Product product,@PathVariable("productName") final String productName) throws ProductNotFoundException,ProductServiceException
	{ 
		
		return productService.updateProductByProductName(product,productName);
	}
	
	@PutMapping(path="/deleteUser/{productName}")
	public List<Product> deleteUser(@PathVariable("productName") final String productName)  throws ProductNotFoundException,ProductServiceException
	{
		
		return productService.deleteProduct(productName);
	}
	
	
	/*
	 * @GetMapping(path="/Auth/{username}/{password}") public User
	 * authenticateUser(@PathVariable("userName") final String
	 * userName,@PathVariable("password") final String password) throws
	 * ProductNotFoundException,ProductServiceException {
	 * 
	 * return userService.authenticateUser(userName, password); }
	 */
	
}
