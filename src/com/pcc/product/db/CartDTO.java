package com.pcc.product.db;

// 카트 관련 정보 객체

public class CartDTO {
	private int cart_num;
	private int prod_num;
	private String prod_name;
	private String prod_img;//원본 파일명
	private String prod_real_img;//실제 업로드 된 파일명(중복처리됨)
	private String requirements;
	private int prod_count;
	private int price;
	private int total_price;
	
	
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
		return "CartDTO [cart_num=" + cart_num + ", prod_num=" + prod_num + ", prod_name=" + prod_name + ", prod_img="
				+ prod_img + ", prod_real_img=" + prod_real_img + ", requirements=" + requirements + ", prod_count="
				+ prod_count + ", price=" + price + ", total_price=" + total_price + "]";
	}
	
}
