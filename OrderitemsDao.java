package com.food.Dao;

import java.util.ArrayList;

import com.food.model.Orderitems;

public interface OrderitemsDao {
	void addOrderitems(Orderitems orderitems);
	Orderitems getOrderitems(int orderitemsId);
	void updateOrderitems(Orderitems orderitems);
	void deleteOrderitems(int orderitemsId);
	ArrayList<Orderitems>getAllOrderitems();

}
