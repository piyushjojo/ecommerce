package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_inventory")
public class ProductInventory extends BaseEntity {
	
	@Column(name = "seller_id")
	private Long sellerId;
	@Column(name = "product_cat_id")
	private Long productCategoryId;
	private Integer quantity;

}
