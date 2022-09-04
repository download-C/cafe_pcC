package com.pcc.manager.db;

public class MangerDTO {
	private int mgr_num; 
	private String mgr_name;
	private int mgr_job;
	
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
	public int getMgr_job() {
		return mgr_job;
	}
	public void setMgr_job(int mgr_job) {
		this.mgr_job = mgr_job;
	}
	
	@Override
	public String toString() {
		return "MangerDTO [mgr_num=" + mgr_num + ", mgr_name=" + mgr_name + ", mgr_job=" + mgr_job + "]";
	}
	
}
