package com.tafa.farmer.models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "user", uniqueConstraints = @UniqueConstraint(columnNames = "Email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name")
	private String name;

	private int phone;

	private String email;

	private String password;

	private String address;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))

	private Collection<Role> roles;

	private String croplist;
	



	public User() {

	}

	public User(String name, int phone, String email, String password, String address,
			Collection<Role> roles, String croplist) {
		super();

		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.address = address;
		this.roles = roles;
		this.croplist = croplist;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public List<Long> getCroplist() {
		List<Long> lstVals = new ArrayList<Long>();
		Long val = 0L;
		if (this.croplist == null || this.croplist.isBlank() || this.croplist.isEmpty()) {
			return lstVals;
		}
		for (String field : this.croplist.split(",")) {
			try {
				val = Long.parseLong(field);
			}
			// If the String contains other thing that digits and commas
			catch (NumberFormatException e) {
			}
			lstVals.add(val);
		}

		return lstVals;
	}

	public void setCroplist(List<Long> vals) {
		String newVals = "";
		for (Long i : vals) {
			if (newVals == "") {
				newVals += Long.toString(i);
			} else {
				newVals = newVals + "," + Long.toString(i);
			}
		}
		this.croplist = newVals;
	}
	
	public List<Long> getMyCrops() {
		List<Long> lstVals = new ArrayList<Long>();
		Long val = 0L;
		if (this.croplist == null || this.croplist.isBlank() || this.croplist.isEmpty()) {
			return lstVals;
		}
		for (String field : this.croplist.split(",")) {
			try {
				val = Long.parseLong(field);
			}
			// If the String contains other thing that digits and commas
			catch (NumberFormatException e) {
			}
			lstVals.add(val);
		}

		return lstVals;
	}

	public void setMyCrops(List<Long> vals) {
		String newVals = "";
		for (Long i : vals) {
			if (newVals == "") {
				newVals += Long.toString(i);
			} else {
				newVals = newVals + "," + Long.toString(i);
			}
		}
		this.croplist = newVals;
	}

	
}
