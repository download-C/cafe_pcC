package com.pcc.member.db;

import java.sql.Timestamp;

// 회원 관련 정보 객체

public class MemberDTO {
	private int mem_num;
	private String phone;
	private String password;
	private String name;
	private Timestamp regdate;
	
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setReg_date(Timestamp reg_date) {
		this.regdate = reg_date;
	}
	
	@Override
	public String toString() {
		return "memberDTO [mem_num=" + mem_num + ", phone=" + phone + ", password=" + password + ", name=" + name
				+ ", reg_date=" + regdate + "]";
	}
	
}