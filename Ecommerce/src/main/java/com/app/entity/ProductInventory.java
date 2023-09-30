package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "product_inventory")
public class ProductInventory extends BaseEntity {
	
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product productId;
	@ManyToOne
	@JoinColumn(name = "seller_id", referencedColumnName = "id")
	private Users sellerId;
	@ManyToOne
	@JoinColumn(name = "product_cat_id", referencedColumnName = "id")
	private ProductCategory productCategoryId;
	private int quantity;

}
