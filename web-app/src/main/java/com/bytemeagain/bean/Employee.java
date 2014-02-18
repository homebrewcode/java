package com.bytemeagain.bean;

public class Employee {

	private String name;
	private String phoneNumber;
	private String email;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", phoneNumber=" + phoneNumber
				+ ", email=" + email + "]";
	}

}