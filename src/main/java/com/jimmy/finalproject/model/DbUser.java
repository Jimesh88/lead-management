package com.jimmy.finalproject.model;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class DbUser {
	private long userId;
	private String userName;
	
	
	 private String password;
	 
	 
	private String confirmPassword;
	
	private Role role;
	private String department;
	
	private String status;
	
	public DbUser(long userId,String userName, String password, Role role,String department)
	{
		this.department=department;
		this.password=password;
		this.role=role;
		this.userId=userId;
		this.userName=userName;
		
		
	}
	public DbUser()
	{}
	
		
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public static String[] getDepartments() {
		return departments;
	}
	public long getUserId() {
		return userId;
	}
		
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	

	public static final String[] departments={"Sales","Marketing","Support","Engineering","HR","Administration"};
	
	
}
