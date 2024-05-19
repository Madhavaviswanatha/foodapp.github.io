package com.food.Dao;

import java.util.List;

import com.food.model.Orders;

public interface OrdersDao {
	void addOrders(Orders order);
	Orders getOrders(int orderId);
	void updateOrders(Orders order);
	void deleteOrders(int orerId);
	List<Orders>getAllOrders();

}
