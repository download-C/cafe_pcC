package com.pcc.product.db;

// 제품 관련 정보 객체

public class ProductDTO {
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
	private int prod_num;
	private String prod_name;
	private String category;
	private int price;
	private String prod_img;//원본 파일명
	private String prod_real_img;//실제 업로드 된 파일명(중복처리됨)
	
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
				+ price + ", prod_img=" + prod_img + ", prod_real_img=" + prod_real_img + "]";
	}
	
}
