package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cart")
public class Cart extends BaseEntity{

	@Column(name = "user_id" )
	private Long userId ;  
	@Column(name ="product_id")
	private Long productId ; 
	private Integer quantity ; 
}
