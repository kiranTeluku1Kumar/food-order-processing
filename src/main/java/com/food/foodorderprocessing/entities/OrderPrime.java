package com.food.foodorderprocessing.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_prm")
public class OrderPrime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_num")
	private int orderNum;

	@Column(name = "cust_id")
	private int custId;

	@Column(name = "total")
	private Double total;

	@OneToMany(mappedBy = "orderPrime")
	private Set<OrderDetails> orderDetails;

	@ManyToOne
	@JoinColumn(name = "order_prm_cust_id")
	private CustomerDetails customerDetails;

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public Double getCostOforder() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return " {\"orderNum\":" + orderNum + ", \"custId\":" + custId + ", \"total\":" + total + "}";
	}

}
