package org.springframework.samples.controller.member;

import javax.validation.Valid;
import javax.validation.constraints.AssertTrue;
//import javax.validation.constraints.Max;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.samples.model.Address;

public class MemberRegistRequest {
	private String name;
	
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,}$")
	private String password;
	
	@NotEmpty
	private String confirmPassword;
	
	//@AssertTrue
	//private boolean samePasswordConfirmPassword;
	
	@NotEmpty 
	@Pattern(regexp = "^01[01679]-\\d{3,4}-\\d{4}$")
	private String phone;

	@NotEmpty
	private String email;

	@Valid
	private Address address;
	
	private String type;
	
	@NotEmpty
	private String title;
	
	//@NotNull
	//@Max(20)
	@Range(min=1, max=20)	// hibernate validation API
	private int length;
	
	private boolean online;
	
	@NotEmpty	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@AssertTrue
	public boolean isSamePasswordConfirmPassword() {
		if (password == null || confirmPassword == null)
			return false;
		return password.equals(confirmPassword);
	}

	public boolean hasPassword() {
		return password != null && password.trim().length() > 0;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String phone) {
		this.email = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	@Override
	public String toString() {
		return "MemberRegistRequest [name=" + name + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ ", phone=" + phone + ", address=" + address + ", type=" + type + ", title=" + title + ", length="
				+ length + ", online=" + online + "]";
	}

	
}
