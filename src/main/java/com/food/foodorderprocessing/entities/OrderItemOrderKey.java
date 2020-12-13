package com.food.foodorderprocessing.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrderItemOrderKey implements Serializable{
	
	@Column(name="order_det_num")
	private int orderDetNum;
	
	@Column(name="order_num")
	private int orderNum;

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

}
