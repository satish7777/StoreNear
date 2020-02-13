package com.meda.product.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meda.product.productservice.entities.Category;



public interface CategoryRepository extends JpaRepository<Category, Long>{

}
