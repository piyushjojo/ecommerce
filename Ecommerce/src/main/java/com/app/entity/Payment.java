package com.app.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "payment")
public class Payment extends BaseEntity {

	@OneToOne
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private Orders orderId ; 
	@Column(name="order_amount")
	private Double totalOrderAmount ;
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod ;
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus ; 
	@Column(name = "payment_time_stamp")
	private LocalDateTime paymentDateTime ; 
}
