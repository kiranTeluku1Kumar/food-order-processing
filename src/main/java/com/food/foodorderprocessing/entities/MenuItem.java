package com.food.foodorderprocessing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="menu_items")
public class MenuItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="cost_of_item")
	private double costOfItem;

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getCostOfItem() {
		return costOfItem;
	}

	public void setCostOfItem(double costOfItem) {
		this.costOfItem = costOfItem;
	}

	@Override
	public String toString() {
		return "{\"itemId\":" + itemId + ", \"itemName\":\" " + itemName + "\", \"costOfItem\":" + costOfItem + "}";
	}
	
}
