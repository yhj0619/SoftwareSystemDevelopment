package org.springframework.samples.model;

import java.util.Date;

public class MemberInfo {
	private String id;
	private String name;
	private String password;
	private String phone;
	private Address address;
	private PerformType type;
	private String title;
	private int length;
	private boolean online;
	private Date regTime;
	
	public MemberInfo(String id, String name, String password, String phone, Address address, PerformType type,
			String title, int length, boolean online, Date regTime) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.type = type;
		this.title = title;
		this.length = length;
		this.online = online;
		this.regTime = regTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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

	public PerformType getType() {
		return type;
	}

	public void setType(PerformType type) {
		this.type = type;
	}

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}
	
	public boolean matchPassword(String inputPassword) {
		return password.equals(inputPassword);
	}

	public Date getRegTime() {
		return regTime;
	}

	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

}
