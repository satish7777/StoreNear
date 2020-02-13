package com.meda.product.productservice.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meda.product.productservice.entities.Category;
import com.meda.product.productservice.entities.Product;
import com.meda.product.productservice.exception.CategoryNotFoundException;
import com.meda.product.productservice.exception.CategoryServiceException;
import com.meda.product.productservice.exception.ProductNotFoundException;
import com.meda.product.productservice.exception.ProductServiceException;
import com.meda.product.productservice.service.CategoryService;


@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	//@RequestMapping(path="/AddCategory",method=RequestMethod.POST)
	@PostMapping(path="/AddCategory",consumes = "application/x-www-form-urlencoded")
	public void createUser(@RequestBody Category category)  throws CategoryServiceException, Exception
	{
		
		
		
		  Category newcategory = category;
		  newcategory.setImage(category.getPathFile().getBytes());
		 
		
		 categoryService.createCategory(newcategory);
		
	}
	
	
	@PostMapping(path="/add",consumes = {"multipart/form-data"})
	public void createUser(@RequestPart(value="category") String category,@RequestPart(value="image") final MultipartFile images)  throws CategoryServiceException, Exception
	{
		
		 ObjectMapper mapper = new ObjectMapper();
		 
		
		  Category newcategory = mapper.readValue(category,Category.class);
		// System.out.println("-------------------------"+ newcategory.getCategoryName()); 
		  //newcategory.setCategoryName("Seetharam");
		  newcategory.setImage(images.getBytes());
		 
		
		 categoryService.createCategory(newcategory);
		
	}
	

	@RequestMapping(path="/getAllCategories",method=RequestMethod.GET)
	public List<Category> getAllUsers()  throws CategoryNotFoundException,CategoryServiceException
	{
		
		return categoryService.findAllCategories();
	}

}
