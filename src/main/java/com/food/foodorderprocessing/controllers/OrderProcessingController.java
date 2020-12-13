package com.food.foodorderprocessing.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.food.foodorderprocessing.entities.OrderPrime;
import com.food.foodorderprocessing.req.OrderRequest;
import com.food.foodorderprocessing.services.OrderProcessingService;

@RestController
public class OrderProcessingController {
	
	@Autowired
	private OrderProcessingService ordPrcSvc;

	@RequestMapping("/orders/all")
	public List<OrderPrime> giveAllOrders(){
		System.out.println("all orders");
		return ordPrcSvc.fetchAllOrders();
	}

	@RequestMapping("/orders/{orderId}")
	public OrderPrime giveOrderDetails(@PathVariable("orderId")String orderId){
		System.out.println("single order get");
		return ordPrcSvc.fetchAllOrders().stream().filter(ord -> ord.getOrderNum() == Integer.valueOf(orderId)).findFirst().get();
		
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public int saveOrderAndProcess(@RequestBody OrderRequest ord) {
		System.out.println("saveOrderAndProcess order post");
		return ordPrcSvc.saveOrderAndProcess(ord);
	}
}
