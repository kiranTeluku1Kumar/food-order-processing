package com.food.foodorderprocessing.enums;

public enum OrderStatus {
	TODO("TODO"),
	INPROGRESS("INPROGRESS"),
	PACKED_READY_FOR_DELIVERY("PACKED_READY_FOR_DELIVERY"),
	ORDER_COMPLETE("PACKED_READY_FOR_DELIVERY");
	
	private String status;
	
	OrderStatus(String status) {
		this.status = status;
	}

	public String getOrderStaus(){
		return status;
	}

}
