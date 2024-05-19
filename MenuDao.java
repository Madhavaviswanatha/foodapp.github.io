package com.food.Dao;


import java.util.List;

import com.food.model.Menu;

public interface MenuDao {
	void addMenu(Menu menu);
	List<Menu>getMenu(int restaurantId);
	void updateMenu(Menu menu);
	void deleteMenu(int menuId);
	
	List<Menu>getAllMenu();

	
	Menu getMenubyId(int menuId);
	
	
}
