package com.food.model;

import java.util.HashMap;
import java.util.Map;

public class Cartitem {
    int itemId;
    int restaurantId;
    String itemName;
    public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	float price;
    int quantity;

    public Cartitem() {
        // TODO Auto-generated constructor stub
    }

    public Cartitem(int itemId, int restaurantId,String itemName, float price, int quantity) {
        super();
        this.itemId = itemId;
        this.restaurantId = restaurantId;
        this.itemName=itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}


