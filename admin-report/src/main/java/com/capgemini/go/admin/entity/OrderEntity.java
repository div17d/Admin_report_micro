package com.capgemini.go.admin.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="`order`")
public class OrderEntity {
	@Id
	@Column(name = "order_id")
	int orderID;
	@Column(name = "dispatch_status")
	Boolean orderDispatchStatus;
	@Column(name = "user_id")
	String userID;
	@Column(name = "address_id")
	int addressId;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_initiate_time")
	LocalDateTime orderInitiateTime;
	//@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "order_dispatch_time")
	LocalDateTime orderDispatchTime;
	@Column(name="product_id")
	private String productID;
	
	public OrderEntity() {
		super();
	}



	public OrderEntity(int orderID, Boolean orderDispatchStatus, String userID, int addressId,
			LocalDateTime orderInitiateTime, LocalDateTime orderDispatchTime, String productID) {
		super();
		this.orderID = orderID;
		this.orderDispatchStatus = orderDispatchStatus;
		this.userID = userID;
		this.addressId = addressId;
		this.orderInitiateTime = orderInitiateTime;
		this.orderDispatchTime = orderDispatchTime;
		this.productID = productID;
	}



	public int getOrderID() {
		return orderID;
	}



	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}



	public Boolean getOrderDispatchStatus() {
		return orderDispatchStatus;
	}



	public void setOrderDispatchStatus(Boolean orderDispatchStatus) {
		this.orderDispatchStatus = orderDispatchStatus;
	}



	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public int getAddressId() {
		return addressId;
	}



	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}



	public LocalDateTime getOrderInitiateTime() {
		return orderInitiateTime;
	}



	public void setOrderInitiateTime(LocalDateTime orderInitiateTime) {
		this.orderInitiateTime = orderInitiateTime;
	}



	public LocalDateTime getOrderDispatchTime() {
		return orderDispatchTime;
	}



	public void setOrderDispatchTime(LocalDateTime orderDispatchTime) {
		this.orderDispatchTime = orderDispatchTime;
	}



	public String getProductID() {
		return productID;
	}



	public void setProductID(String productID) {
		this.productID = productID;
	}
	
	


}
