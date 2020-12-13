package com.food.foodorderprocessing.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="customer_details")
public class CustomerDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_id")
	private int custId;
	
	@Column(name="cust_name")
	private String custName;
	
	@Column(name="cust_phone_num")
	private int custPhoneNum;
	
	@OneToMany(mappedBy = "customerDetails")
	private Set<OrderPrime> orders;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getCustPhoneNum() {
		return custPhoneNum;
	}

	public void setCustPhoneNum(int custPhoneNum) {
		this.custPhoneNum = custPhoneNum;
	}

	public Set<OrderPrime> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderPrime> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "{\"custId\":" + custId + ", \"custName\":\"" + custName + " \", custPhoneNum=" + custPhoneNum + "\"orders\":["+ orders +"]}";
	}
	
	
}
