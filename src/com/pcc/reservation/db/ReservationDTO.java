package com.pcc.reservation.db;

import java.sql.Date;
import java.sql.Time;

// 예약 관련 정보 객체

public class ReservationDTO {
	private int res_num;
	private int mem_num;
	private String res_date;
	private String res_hour;
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
	public String getRes_hour() {
		return res_hour;
	}
	public void setRes_hour(String res_time) {
		this.res_hour = res_time;
	}
	public int getRes_num_of_persons() {
		return res_num_of_persons;
	}
	public void setRes_num_of_persons(int res_num_of_persons) {
		this.res_num_of_persons = res_num_of_persons;
	}
	@Override
	public String toString() {
		return "ReservationDTO [res_num=" + res_num + ", mem_num=" + mem_num + ", res_date=" + res_date + ", res_hour="
				+ res_hour + ", res_num_of_persons=" + res_num_of_persons + "]";
	}
	
	
	
}
