package com.food.foodorderprocessing.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.food.foodorderprocessing.entities.OrderPrime;

@Repository
public interface OrderRepository extends CrudRepository<OrderPrime, Integer>{

}
