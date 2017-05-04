package com.atmecs.pojo;

public class Employee {
	private String Email;
	private String Name;
	private String password;
	public String getEmail() {
		return Email;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return Name;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public void setName(String name) {
		Name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
