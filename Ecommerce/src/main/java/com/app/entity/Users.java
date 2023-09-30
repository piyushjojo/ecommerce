package com.app.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class Users extends BaseEntity {
	
	@Column(name = "username")
	@NotBlank(message = "username is required.")
	private String username ; 
	
	@NotBlank(message = "Email is required.")
	private String email ; 
	@NotBlank(message = "Password is required.")
	private String password ; 
	
	@Column(name = "first_name")
	@NotBlank(message = "First Name is required.")
	private String firstName ; 
	
	@Column(name = "middle_name")
	private String middleName ;
	
	@Column(name = "last_name")
	@NotBlank(message = "Last Name is required.")
	private String lastName ; 
	
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Gender is required.")
	private Gender gender ; 
	
	@Enumerated(EnumType.STRING)
	@NotBlank(message = "Gender is required.")
	private UserRole role ; 
	private LocalDate dob ; 
	
	@NotBlank(message = "Phone No is required.")
	private String phoneNo ;
	
	@Column(name = "active_status")
	private String activeStatus ; 
		
	@Column(name = "display_picture_path")
	private String displayPicturePath ; 
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL)
    private List<Address> addresses;
}
