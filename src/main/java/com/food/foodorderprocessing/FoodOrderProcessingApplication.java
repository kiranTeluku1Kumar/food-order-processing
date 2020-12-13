package com.food.foodorderprocessing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableFeignClients("com.food.foodorderprocessing")
@EnableDiscoveryClient
@EnableTransactionManagement
public class FoodOrderProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodOrderProcessingApplication.class, args);
	}

}