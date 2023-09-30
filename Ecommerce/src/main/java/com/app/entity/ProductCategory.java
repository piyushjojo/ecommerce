package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_category")
public class ProductCategory extends BaseEntity{

	@Column(name = "cat_name")
	private String categoryName ; 
	@Column(name = "cat_desc")
	private String categoryDescription ;
	
}
