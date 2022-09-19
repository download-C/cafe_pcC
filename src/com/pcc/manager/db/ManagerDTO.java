package com.pcc.manager.db;

public class ManagerDTO {
	int mgr_num;
	String mgr_id;
	String mgr_password;
	String mgr_name;
	String mgr_job;
	String mgr_title;
	
	public String getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}
	public String getMgr_password() {
		return mgr_password;
	}
	public void setMgr_password(String mgr_password) {
		this.mgr_password = mgr_password;
	}
	
	public int getMgr_num() {
		return mgr_num;
	}
	public void setMgr_num(int mgr_num) {
		this.mgr_num = mgr_num;
	}
	public String getMgr_name() {
		return mgr_name;
	}
	public void setMgr_name(String mgr_name) {
		this.mgr_name = mgr_name;
	}
	public String getMgr_job() {
		return mgr_job;
	}
	public void setMgr_job(String mgr_job) {
		this.mgr_job = mgr_job;
	}
	public String getMgr_title() {
		return mgr_title;
	}
	public void setMgr_title(String mgr_title) {
		this.mgr_title = mgr_title;
	}
	
	@Override
	public String toString() {
		return "ManagerDTO [mgr_num=" + mgr_num + ", mgr_id=" + mgr_id + ", mgr_password=" + mgr_password
				+ ", mgr_name=" + mgr_name + ", mgr_job=" + mgr_job + ", mgr_title=" + mgr_title + "]";
	}
	
}
