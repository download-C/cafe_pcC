package com.pcc.product.db;

// 카트 관련 정보 객체

public class CartDTO {
	private int cart_num;
	private int mem_num;
	private int prod_num;
	private String requirements;
	private int total_price;
	
	public int getCart_num() {
		return cart_num;
	}
	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}
	public int getMem_num() {
		return mem_num;
	}
	public void setMem_num(int mem_num) {
		this.mem_num = mem_num;
	}
	public int getProd_num() {
		return prod_num;
	}
	public void setProd_num(int prod_num) {
		this.prod_num = prod_num;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public int getTotal_price() {
		return total_price;
	}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	
	@Override
	public String toString() {
		return "cartDTO [cart_num=" + cart_num + ", mem_num=" + mem_num + ", prod_num=" + prod_num + ", requirements="
				+ requirements + ", total_price=" + total_price + "]";
	}
	
}
