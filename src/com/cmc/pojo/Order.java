package com.cmc.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Orders")
public class Order implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private int orderId;
	
	@Column(name = "customerId")
	private String customerId;
	
	@Column(name = "orderDate")
	private Date orderDate;
	
	@Column(name = "requiredDate")
	private Date requiredDate;
	
	@Column(name = "shippedDate")
	private Date shippedDate;
	
	@Column(name = "shipAddress")
	private String shipAddress;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "order")
	private Set<OrderDetail> orderDetails;

	
	
	public Order() {
		super();
	}

	public Order(String customerId, Date orderDate, Date requiedDate, Date shippedDate, String shipAddress) {
		super();
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.requiredDate = requiedDate;
		this.shippedDate = shippedDate;
		this.shipAddress = shipAddress;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiedDate() {
		return requiredDate;
	}

	public void setRequiedDate(Date requiedDate) {
		this.requiredDate = requiedDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Set<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	
	
	
	
}
