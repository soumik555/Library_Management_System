package com.jsp.Library_Management_System.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.Library_Management_System.repository.LibraryUserRepository;


@Component
public class LibraryUserDao {
	
	@Autowired
	LibraryUserRepository userRepository;
	
	
	public boolean existsByEmail(String email)
	{
		return userRepository.existsByEmail(email);
		
	}

}
