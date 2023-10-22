package com.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address extends BaseEntity{

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private Users userId ; 
	private String street; 
	private String city ; 
	private String state ; 
	private String country ; 
	private String pincode ; 
	@Column(name = "primary_address")
	private String primaryAddress ; 
}
