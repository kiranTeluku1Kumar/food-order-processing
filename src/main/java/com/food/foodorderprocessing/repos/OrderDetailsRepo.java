package com.food.foodorderprocessing.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.foodorderprocessing.entities.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer> {

}
