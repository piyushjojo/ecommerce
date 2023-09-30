package com.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "order_details")
public class OrderDetails extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "order_id" , referencedColumnName = "id")
	private Orders orderId ; 
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private Product productId ; 
	@Column(name = "product_price")
	private double productPriceAtOrder ; 
	private int quantity  ; 
	@Column(name = "order_time_stamp")
	private LocalDateTime orderPlacedAt ;
	
}
