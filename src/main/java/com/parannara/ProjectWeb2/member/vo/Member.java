package com.parannara.ProjectWeb2.member.vo;

public class Member {
	private String memberId;
	private String password;
	private String name;
	private String email;
	private String phoneNum;
	private String memberNum;
	private String address;
	public Member() {
	}
	public Member(String memberId, String password, String name, String email, String phoneNum, String memberNum,
			String address) {
		super();
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phoneNum = phoneNum;
		this.memberNum = memberNum;
		this.address = address;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getMemberNum() {
		return memberNum;
	}
	public void setMemberNum(String memberNum) {
		this.memberNum = memberNum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", phoneNum=" + phoneNum + ", memberNum=" + memberNum + ", address=" + address + "]";
	}
	
}