package com.meda.product.productservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meda.product.productservice.entities.Category;
import com.meda.product.productservice.entities.Product;
import com.meda.product.productservice.exception.CategoryNotFoundException;
import com.meda.product.productservice.exception.CategoryServiceException;
import com.meda.product.productservice.exception.ProductServiceException;
import com.meda.product.productservice.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	public void createCategory(Category category) throws CategoryServiceException, Exception
	 {
		

		categoryRepository.save(category) ;
	}

	
	
	public List<Category> findAllCategories()  throws CategoryServiceException
	{ 
		try {
		return categoryRepository.findAll();
	  }catch(Exception e) {
		  e.printStackTrace();
		
		throw new CategoryServiceException("Exception occured while fetching the Categories" ,e);
		
	}
	}

}
