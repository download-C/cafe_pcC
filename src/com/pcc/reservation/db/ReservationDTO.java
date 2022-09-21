package com.pcc.reservation.db;

import java.sql.Date;

public class ReservationDTO {
	private int res_num;
	private int mem_num;
	private String res_date;
	private int res_num_of_persons;
	
	
	public int getRes_num() {
		return res_num;
	}
	public void setRes_num(int res_num) {
		this.res_num = res_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public String getRes_date() {
		return res_date;
	}
	public void setRes_date(String res_date) {
		this.res_date = res_date;
	}
	public int getRes_num_of_persons() {
		return res_num_of_persons;
	}
	public void setRes_num_of_persons(int res_num_of_persons) {
		this.res_num_of_persons = res_num_of_persons;
	}
	
	
	
}
