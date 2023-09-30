package com.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "orders")
public class Orders extends BaseEntity {

	@ManyToOne
	@JoinColumn(name ="user_id", referencedColumnName = "id")
	private Users userId ; 
	@Column(name = "order_amount")
	private double totalOrderAmount ;
	@OneToOne
	@JoinColumn(name = "payment_id" , referencedColumnName = "id")
	private Payment paymentId ; 
	@Column(name = "order_time_stamp")
	private LocalDateTime orderPlacedAt ; 
	
}
