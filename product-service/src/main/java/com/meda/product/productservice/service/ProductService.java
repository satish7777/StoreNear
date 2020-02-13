package com.meda.product.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meda.product.productservice.entities.Product;
import com.meda.product.productservice.exception.ProductNotFoundException;
import com.meda.product.productservice.exception.ProductServiceException;
import com.meda.product.productservice.repository.ProductRepository;



@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	



	public Product createProduct(Product product)  throws ProductServiceException,Exception
	{
		try {
			Product ProductCheck  = getProductByProductName(product.getProductName());
			
			if(ProductCheck!=null) {
				 throw new ProductServiceException("Product Already Exists ");
				
			}else {
			
		productRepository.save(product);
		return productRepository.getOne(product.getProductId());
			}
		}catch(ProductServiceException e) {
			
			throw e;
			
		}
		catch(Exception e) {
			
			throw new Exception("Exception occured while creating the Product" ,e);
			
		}
	 }


	



	public List<Product> findAllProductInfo()  throws  ProductNotFoundException,ProductServiceException
	{ 
		try {
		return productRepository.findAllProductInfo();
	  }catch(Exception e) {
		
		throw new ProductServiceException("Exception occured while fetching the Products" ,e);
		
	}
	}



	public Product getProductByProductName(String productName)  throws ProductNotFoundException,ProductServiceException
	 {
		try {
		return productRepository.findByProductName(productName);
	 }catch(ProductNotFoundException e) {
			
			throw new ProductNotFoundException("Product Doesn't Exists" ,e);
			
		}catch(Exception use) {
			throw new ProductServiceException("Exception occured while fetching the Product" ,use);
		}
	}


	public Product updateProductByProductName(Product product, String productName)  throws ProductNotFoundException,ProductServiceException
	{
		try {
		Product update = getProductByProductName(productName);
		
		if(update!=null) {
		update.setProductName(product.getProductName());
		update.setQuantityPerUnit(product.getQuantityPerUnit());
		update.setUnitPrice(product.getUnitPrice());
		update.setCategory(product.getCategory());
		update.setUnitsInStock(product.getUnitsInStock());
		update.setDisStatus(product.getDisStatus());
		productRepository.save(update);
		return getProductByProductName(productName);
		}else {
			throw new ProductNotFoundException("Product Doesn't exists");
		}
	}catch(ProductNotFoundException e) {
		//e.printStackTrace();
		
		throw e;
	}catch(Exception e) {
		throw new ProductServiceException("Exception occured while updating the Product::"+e.getMessage() );
	}
	}



	public List<Product> deleteProduct(String productName)  throws ProductNotFoundException,ProductServiceException
	 {
		try {
		Product product = getProductByProductName(productName);
		if(product!=null) {
		productRepository.delete(product);
		return findAllProductInfo();
		
	 }else {
			throw new ProductNotFoundException("Product Doesn't exists");
		}
	}catch(ProductNotFoundException e) {
		//e.printStackTrace();
		throw e;
	}catch(ProductServiceException e) {
		
		throw new ProductServiceException("Exception occured while deleting the Product" ,e);
		
	}catch(Exception e) {
		
		throw new ProductServiceException("Exception occured while deleting the Product"+e.getMessage());
		
	}
		
	}

}
