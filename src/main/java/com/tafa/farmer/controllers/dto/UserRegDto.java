package com.tafa.farmer.controllers.dto;

public class UserRegDto {

	private String name;
	private int phone;
	private String email;
	private String password;
	private String address;
	private String croplist;


	public UserRegDto() {

	}

	public UserRegDto(String name, int phone, String email, String password, String address, String croplist) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
		this.croplist = croplist;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCroplist() {
		return croplist;
	}

	public void setCroplist(String croplist) {
		this.croplist = croplist;
	}


}