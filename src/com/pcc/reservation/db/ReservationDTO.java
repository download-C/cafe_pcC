package com.pcc.reservation.db;

import java.sql.Date;
import java.sql.Time;

// 예약 관련 정보 객체

public class ReservationDTO {
	private int res_num;
	private int mem_num;
	private Date res_date;
	private Time res_time;
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
	public Date getRes_date() {
		return res_date;
	}
	public void setRes_date(Date res_date) {
		this.res_date = res_date;
	}
	public Time getRes_time() {
		return res_time;
	}
	public void setRes_time(Time res_time) {
		this.res_time = res_time;
	}
	public int getRes_num_of_persons() {
		return res_num_of_persons;
	}
	public void setRes_num_of_persons(int res_num_of_persons) {
		this.res_num_of_persons = res_num_of_persons;
	}
	@Override
	public String toString() {
		return "ReservationDTO [res_num=" + res_num + ", mem_num=" + mem_num + ", res_date=" + res_date + ", res_time="
				+ res_time + ", res_num_of_persons=" + res_num_of_persons + "]";
	}
	
}
