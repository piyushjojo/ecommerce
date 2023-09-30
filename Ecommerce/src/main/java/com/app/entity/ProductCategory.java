package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_category")
public class ProductCategory extends BaseEntity{

	private String categoryName ; 
	private String categoryDescription ;
	
}
