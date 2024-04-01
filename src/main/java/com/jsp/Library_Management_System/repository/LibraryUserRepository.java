package com.jsp.Library_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Library_Management_System.dto.LibraryUser;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Integer>
{
	
	boolean existsByEmail(String email);

}
