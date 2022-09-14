package com.pcc.order.db;

import java.sql.Timestamp;

// 주문 관련 정보 객체

public class OrderDTO {
	private int order_num;
	private int mem_num;
	private int cart_num;
	private Timestamp order_date;
	private String order_method;
	private String order_state;
	
	public int getOrder_num() {
		return order_num;
	}
	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public Timestamp getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Timestamp order_date) {
		this.order_date = order_date;
	}
	public String getOrder_method() {
		return order_method;
	}
	public void setOrder_method(String order_method) {
		this.order_method = order_method;
	}
	public String getOrder_state() {
		return order_state;
	}
	public void setOrder_state(String order_state) {
		this.order_state = order_state;
	}
	@Override
	public String toString() {
		return "orderDTO [order_num=" + order_num + ", mem_num=" + mem_num + ", cart_num=" + cart_num + ", order_date="
				+ order_date + ", order_method=" + order_method + ", order_state=" + order_state + "]";
	}

}
