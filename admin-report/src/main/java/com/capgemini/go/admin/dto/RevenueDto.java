package com.capgemini.go.admin.dto;

public class RevenueDto {
	String user_id;
	int order_id;
	String product_id;
	String product_catagory;
	double product_price;

	public RevenueDto(String user_id, int order_id, String product_id, String product_catagory, double product_price) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.product_id = product_id;
		this.product_catagory = product_catagory;
		this.product_price = product_price;
	}
	public RevenueDto(String product_id) {
		super();
		this.product_id = product_id;
	
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_catagory() {
		return product_catagory;
	}
	public void setProduct_catagory(String product_catagory) {
		this.product_catagory = product_catagory;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	
	

}
