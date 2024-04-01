package com.jsp.Library_Management_System.controller;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.jsp.Library_Management_System.dao.LibraryUserDao;
import com.jsp.Library_Management_System.dto.LibraryUser;


import jakarta.validation.Valid;


@Controller
public class GeneralController {
	
	
	@Autowired
	LibraryUser libraryUser;
	
	@Autowired
	LibraryUserDao userDao;
	
	
	
	
	
	@GetMapping("/")
	public String loadhome()
	{
		return "home";
	}
	
	@GetMapping("login")
	public String loadLogin()
	{
		return "login";
	}
	
	
	
	
//	@GetMapping("/signup")
//	public String loadSignup()
//	{
//		return "signup";
//	}
//	
	
	
	@GetMapping("signup")
	
	public String loadSignup( ModelMap map)
	
	{
	map.put("libraryUser", libraryUser);//classname should be always in lowercase
		return "signup";
	}
	

@PostMapping("/signup")

public String  Signup( @Valid LibraryUser libraryUser,BindingResult result)
{
  if(LocalDate.now().getYear()-libraryUser.getDob().getYear()<18)
  {
	result.rejectValue("dob", "error.dob", "*Age should be greater than 18");
  }
  
  if(!libraryUser.getPassword().equals(libraryUser.getConfirm_password()))
  {	  result.rejectValue("confirm_password", "error.confirm_password", "*Password and Confirm Password should be Matching");
  
  
  if(userDao.existsByEmail(libraryUser.getEmail()))
  {
	  result.rejectValue("email", "error.email", "*Email should be unique");
	  
	  
  }
	
  }
  if(result.hasErrors())
  {
	  return "signup";
  }
  
  
  return "login";
}
	
	
	
	

}
