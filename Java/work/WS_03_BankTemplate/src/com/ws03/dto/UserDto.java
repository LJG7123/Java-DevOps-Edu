package com.ws03.dto;
/**
 *  고객의 정보를 관리할 객체 
 * */
public class UserDto {
	private int userSeq;
	private String name;
	private String email;
	private String phone;
	private Boolean isSleep;
	
	public UserDto() {}

	public UserDto(int userSeq, String name, String email, String phone, Boolean isSleep) {
		super();
		this.userSeq = userSeq;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.isSleep = isSleep;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Boolean isSleep() {
		return isSleep;
	}

	public void setIsSleep(Boolean isSleep) {
		this.isSleep = isSleep;
	}
	
	
}
