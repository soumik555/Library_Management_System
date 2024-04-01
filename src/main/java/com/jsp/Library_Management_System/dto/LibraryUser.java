package com.jsp.Library_Management_System.dto;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Entity
@Data
public class LibraryUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min=3,max=15,message="*The name entered should be between 3~15 characters")
	private String name;
	@DecimalMin(value="60000000000",message="*Enter proper validated number")
	@DecimalMax(value="99999999999",message="*Enter proper validated number")
	private long mobile;
	@NotEmpty(message="*This is a required field")
	@Email(message="*Entered proper email format")
	private String email;
	@NotNull(message="*This is a required field")
	private LocalDate dob;
	@Size(min=8,max=15,message="* Password between 8~15 characters")
	private String password;
	@Size(min=8,max=15,message="*Confirm password between 8~15 characters")
	private String confirm_password;
	@NotNull(message="*This is a required field")
	private String role;
	
	
	
	
	

}
