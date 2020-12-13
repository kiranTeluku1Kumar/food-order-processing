package com.food.foodorderprocessing.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.foodorderprocessing.entities.CustomerDetails;

public interface CustomerRepo extends JpaRepository<CustomerDetails, Integer> {
	@Query("select cust from CustomerDetails cust where upper(custName) in :custName")
	Optional<CustomerDetails> findByCustName(String custName);

}
