package com.food.foodorderprocessing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_details")
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_det_num")
	private int orderDetNum;
	
	@Column(name="order_num")
	private int orderNum;
	
	@ManyToOne
	@JoinColumn(name = "order_num_frn", referencedColumnName = "order_num" )
	private OrderPrime orderPrime;
	
	@OneToOne
	private MenuItem menuItem;
	
	@Column(name="ord_status")
	private String ordStatus;
	
	@Column(name="ord_quantity")
	private int ordQuantity;
	
	
	@Column(name="item_id")
	private int itemId;


	public int getOrderDetNum() {
		return orderDetNum;
	}


	public void setOrderDetNum(int orderDetNum) {
		this.orderDetNum = orderDetNum;
	}


	public int getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}


	public OrderPrime getOrderPrime() {
		return orderPrime;
	}


	public void setOrderPrime(OrderPrime orderPrime) {
		this.orderPrime = orderPrime;
	}


	public String getOrdStatus() {
		return ordStatus;
	}


	public void setOrdStatus(String ordStatus) {
		this.ordStatus = ordStatus;
	}


	public int getOrdQuantity() {
		return ordQuantity;
	}


	public void setOrdQuantity(int ordQuantity) {
		this.ordQuantity = ordQuantity;
	}


	public int getItemId() {
		return itemId;
	}


	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	@Override
	public String toString() {
		return "{\"orderDetNum\":" + orderDetNum + ", \"orderNum\":"+orderNum+", \"ordStatus\":\" " + ordStatus + " \", \"ordQuantity\":" + ordQuantity + ", \"itemId\":" + itemId + "}";
	}
	
}
