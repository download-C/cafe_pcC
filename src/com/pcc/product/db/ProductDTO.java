package com.pcc.product.db;

// 제품 관련 정보 객체

public class ProductDTO {
	private int prod_num;
	private String prod_name;
	private String category;
	private int price;
	
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductDTO [prod_num=" + prod_num + ", prod_name=" + prod_name + ", category=" + category + ", price="
				+ price + "]";
	}
	
}
