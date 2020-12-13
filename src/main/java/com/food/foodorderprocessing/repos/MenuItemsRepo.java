package com.food.foodorderprocessing.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.food.foodorderprocessing.entities.MenuItem;

public interface MenuItemsRepo extends JpaRepository<MenuItem, Integer> {
	@Query("select menuItems from MenuItem menuItems where upper(itemName) in :itemName")
	Optional<MenuItem> findByItemNameInIgnoreCase(String itemName);

}
