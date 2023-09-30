package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product")
public class Product extends BaseEntity{

	@Column(name = "product_name")
	private String productName ; 
	@Column(name = "product_desc")
	private String productDescription ;
	@Column (name = "product_price")
	private Double productPrice ;
	@ManyToOne
	@JoinColumn(name = "product_cat_id", referencedColumnName = "id")
	private ProductCategory productCategoryId ; 
	@ManyToOne
	@JoinColumn(name = "product_inv_id", referencedColumnName = "id")
	private ProductInventory productInventoryId ; 
	@Column(name = "seller_id")
	private Long sellerId ;
	@Column(name = "display_picture_path")
	private String displayPicturePath ; 
	
}
