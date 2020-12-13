package com.food.foodorderprocessing.req;

import java.util.List;

public class OrderRequest {

	private String customerName;
	
	private int customerPhone;

	private List<Items> items;
	
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(int customerPhone) {
		this.customerPhone = customerPhone;
	}
	
	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "{\"customerName\":\"" + customerName + "\", \"customerPhone\":" + customerPhone + ", \"items\":[" + items + "]}";
	}
	
}
