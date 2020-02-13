package com.meda.product.productservice.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@Data
@Entity
@Table(name= "category")
//@JsonIgnoreProperties(ignoreUnknown = false)
public class Category {
	
	public Category () {}
	
	public Category( @Length(max = 80) String categoryName,
			@Length(max = 500) String categoryDescription, 
			@Length(max = 300) String youtubeUrl) {
		
		
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		
		this.youtubeUrl = youtubeUrl;
		
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="categoryId" , updatable = false, nullable = false)
	private Long categoryId;
	
	@Length(max=80)
	@Column(unique=true)
	private String categoryName;
	
	@Length(max=500)
	private String categoryDescription;
	
	
	@Lob
    @Column(name="image")
    private byte[] image;
    
	
	@Transient
	MultipartFile  pathFile;
	
	@Length(max=300)
	private String youtubeUrl;
	
	

	  @OneToMany(mappedBy="category",cascade=CascadeType.ALL) 
	  private List<Product>  products = new ArrayList<Product>();
	 

	public Long getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public String getCategoryDescription() {
		return categoryDescription;
	}


	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}


	public byte[] getImage() {
		return image;
	}


	public void setImage(byte[] image) {
		this.image = image;
	}


	public MultipartFile getPathFile() {
		return pathFile;
	}


	public void setPathFile(MultipartFile pathFile) {
		this.pathFile = pathFile;
	}


	public String getYoutubeUrl() {
		return youtubeUrl;
	}


	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}


	
	/*
	 * public List<Product> getProducts() { return products; }
	 * 
	 * 
	 * public void setProducts(List<Product> products) { this.products = products; }
	 */
	
	
	

}
