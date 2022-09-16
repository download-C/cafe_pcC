package com.pcc.product.db;

import java.sql.Timestamp;

// 주문 관련 정보 객체

public class OrderDTO {
	private int order_num;//주문번호
	private int mem_num;  //주문자 번호
	private String mem_name; //주문자 이름
	private String phone; //주문자 전화번호
	
	private int cart_num; //카트 번호(view)에서 가져오기
	private int prod_count; //조인
	private int total_price;//조인
	
	private int prod_num;
	private String prod_name;
	private String requirements;
	
	private Timestamp order_date; //주문 일시
	private String order_method;  //주문 방법
	private String order_state;   //주문 상태
	private int order_price;     //총 주문 가격
	private int pickup_time;
	
	
	
	public int getPickup_time() {
		return pickup_time;
	}
	public void setPickup_time(int pickup_time) {
		this.pickup_time = pickup_time;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getProd_count() {
		return prod_count;
	}
	public void setProd_count(int prod_count) {
		this.prod_count = prod_count;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
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
		return "OrderDTO [order_num=" + order_num + ", mem_num=" + mem_num + ", mem_name=" + mem_name + ", phone="
				+ phone + ", cart_num=" + cart_num + ", prod_count=" + prod_count + ", total_price=" + total_price
				+ ", prod_num=" + prod_num + ", prod_name=" + prod_name + ", requirements=" + requirements
				+ ", order_date=" + order_date + ", order_method=" + order_method + ", order_state=" + order_state
				+ ", order_price=" + order_price + ", pickup_time=" + pickup_time + "]";
	}
	

}
