package com.food.Dao;

import java.util.List;


import com.food.model.Restaurants;

public interface RestaurantDao {
	int addRestaurant(Restaurants restaurant);
	Restaurants getRestaurant(int restaurantId);
	int updateRestaurant(Restaurants restaurant);
	int deleteRestaurant(int restaurantId);
	List<Restaurants>getAllRestaurants();
	Restaurants searchRestaurant(String name);

}
