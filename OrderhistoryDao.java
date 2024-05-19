package com.food.Dao;

import java.util.ArrayList;

import com.food.model.Orderhistory;

public interface OrderhistoryDao {
	void addOrderhistory(Orderhistory orderhistory);
	Orderhistory getOrderhistory(int orderhistoryId);
	void updateOrderhistrory(Orderhistory orderhistory);
	void deleteOrderhistrory(int orderhistoryId);
	ArrayList<Orderhistory>getAllOrderhistory();

}
