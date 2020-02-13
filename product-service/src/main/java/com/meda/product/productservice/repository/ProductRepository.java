package com.meda.product.productservice.repository;

import org.springframework.stereotype.Repository;

import com.meda.product.productservice.entities.Product;
import com.meda.product.productservice.exception.ProductNotFoundException;
import com.meda.product.productservice.exception.ProductServiceException;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	Product findByProductName(String productName) throws ProductNotFoundException;
	
	
	
	@Query(value="select p.*  , c.category_name from  PRODUCTS p join CATEGORY c on  c.category_id = p.category_id " , nativeQuery = true)
	List<Product> findAllProductInfo() throws ProductNotFoundException,ProductServiceException;
	
	

}
