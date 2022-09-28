package com.pcc.product.db;

import java.sql.Timestamp;

// 주문 관련 정보 객체

public class OrderDTO {
	private int order_num;//주문번호
	private int mem_num;  //주문자 번호
	private String name; //주문자 이름
	private String phone; //주문자 전화번호
	
	//카트리스트에서 가져오기
	private int cart_num; //카트 번호(view)에서 가져오기
	private int prod_num;
	private String prod_name;
	private String prod_img;//원본 파일명
	private String prod_real_img;//실제 업로드 된 파일명(중복처리됨)
	private String requirements;
	private int prod_count;
	private int price;
	private int total_price;
	
	private Timestamp order_time; //주문 일시
	private Timestamp checked; //주문 일시(카트)
	private int order_price;     //총 주문 가격
	private int pickup_time;
	
	
	public Timestamp getChecked() {
		return checked;
	}
	public void setChecked(Timestamp checked) {
		this.checked = checked;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
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
	public String getProd_img() {
		return prod_img;
	}
	public void setProd_img(String prod_img) {
		this.prod_img = prod_img;
	}
	public String getProd_real_img() {
		return prod_real_img;
	}
	public void setProd_real_img(String prod_real_img) {
		this.prod_real_img = prod_real_img;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public int getProd_count() {
		return prod_count;
	}
	public void setProd_count(int prod_count) {
		this.prod_count = prod_count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	public int getOrder_price() {
		return order_price;
	}
	public void setOrder_price(int order_price) {
		this.order_price = order_price;
	}
	public int getPickup_time() {
		return pickup_time;
	}
	public void setPickup_time(int pickup_time) {
		this.pickup_time = pickup_time;
	}
	
	@Override
	public String toString() {
		return "OrderDTO [order_num=" + order_num + ", mem_num=" + mem_num + ", name=" + name + ", phone=" + phone
				+ ", cart_num=" + cart_num + ", prod_num=" + prod_num + ", prod_name=" + prod_name + ", prod_img="
				+ prod_img + ", prod_real_img=" + prod_real_img + ", requirements=" + requirements + ", prod_count="
				+ prod_count + ", price=" + price + ", total_price=" + total_price + ", order_time=" + order_time
				+ ", checked=" + checked + ", order_price=" + order_price + ", pickup_time=" + pickup_time + "]";
	}
	
	

}
