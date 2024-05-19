package com.food.Daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Dao.MenuDao;
import com.food.model.Menu;

public class MenuDaoImpl implements MenuDao {
	

	String INSERT_QUERY="INSERT into `menuitems`(`menuId`,`restaurantId`,`itemName`, `description`, `price`, `isAvailable`) VALUES(?,?,?,?,?,?)";
	String SELECT_QUERY="SELECT * FROM `menuitems` WHERE `restaurantId` = ?";
	String UPDATE_QUERY="UPDATE `menuitems` SET `restaurantId` = ?, `itemName` = ?, `description` = ?, `price` = ?, `isAvailable` = ?,  WHERE `menuId` = ?";
	String DELETE_QUERY="DELETE FROM `menuitems` WHERE `menuId` = ?";
	String SELECT_ALL_QUERY="SELECT * FROM `menuitems`";
	String MENU_ID = "SELECT * FROM `menuitems` WHERE `menuId` = ?" ;

	
	
	private Connection connection;
	public MenuDaoImpl(){
		String url="jdbc:mysql://localhost:3306/food_app";
		String username="root";
		String password="Madhava";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		     connection = DriverManager.getConnection(url,username,password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void addMenu(Menu menu) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		
		try {
			 statement = connection.prepareStatement(INSERT_QUERY);
			 statement.setInt(1, menu.getMenuId());
			 statement.setInt(2, menu.getRestaurantId());
			 statement.setString(3, menu.getItemName());
			 statement.setString(4, menu.getDescription());
			 statement.setFloat(5, menu.getPrice());
			 statement.setString(6, menu.getIsAvailable());
			 int i = statement.executeUpdate();
			 System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<Menu> getMenu(int restaurantId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		ResultSet res=null;
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		
		
		try {
//			 statement = connection.prepareStatement(SELECT_QUERY);
//			 statement.setInt(1, restaurantId);
//			  res = statement.executeQuery();
//			  if(res.next()) {
//				  int i = res.getInt("menuId");
//				  int rId = res.getInt("restaurantId");
//				  String itemName = res.getString("itemName");
//				  String description = res.getString("description");
//				  float price = res.getFloat("price");
//				  String isAvailable = res.getString("isAvailable");
//                  Menu menu = new Menu(i, rId, itemName, description, price, isAvailable);
//		           
//                  menuList.add(menu);
			statement=connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, restaurantId);
	            res=statement.executeQuery();
	            while(res.next()) {
	            	int i = res.getInt("menuId");
	            	String itemName = res.getString("itemName");
	            	String description = res.getString("description");
	            	float price = res.getFloat("price");
	            	String isAvailable = res.getString("isAvailable");
	            	Menu menu = new Menu(i, restaurantId, itemName, description, price, isAvailable);
	            	menuList.add(menu);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public void updateMenu(Menu menu) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(UPDATE_QUERY);
			 statement.setInt(1, menu.getRestaurantId());
			 statement.setString(2, menu.getItemName());
			 statement.setString(3, menu.getDescription());
			 statement.setFloat(4, menu.getPrice());
			 statement.setString(5, menu.getIsAvailable());
			 statement.setInt(6, menu.getMenuId());
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenu(int menuId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(DELETE_QUERY);
			 statement.setInt(1, menuId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Menu> getAllMenu() {
		// TODO Auto-generated method stub
		Statement statement=null;
		ResultSet res=null;
		ArrayList<Menu> menuList = new ArrayList<Menu>();
		try {
			 statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  if(res.next()){
				  int menuId = res.getInt("menuId");
				  int restaurantId = res.getInt("restaurantId");
				  String itemName = res.getString("itemName");
				  String description = res.getString("description");
				  float price = res.getFloat("price");
				  String isAvailable = res.getString("isAvailable");
				  Menu menu = new Menu(menuId, restaurantId, itemName, description, price, isAvailable);
			 
			     menuList.add(menu);
			  
			  }
			  	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public Menu getMenubyId(int menuId) {
	    PreparedStatement statement = null;
	    ResultSet res = null;
	    try {
	        statement = connection.prepareStatement(MENU_ID);
	        statement.setInt(1, menuId);
	        res = statement.executeQuery();
	        if (res.next()) {
	            int i = res.getInt("menuId");
	            int restaurantId = res.getInt("restaurantId");
	            String itemName = res.getString("itemName");
	            String description = res.getString("description");
	            float price = res.getFloat("price");
	            String isAvailable = res.getString("isAvailable");
	            Menu menu = new Menu(i, restaurantId, itemName, description, price, isAvailable);
	            return menu;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	    return null;
	}

		public static void main(String[] args) {
			MenuDaoImpl m = new MenuDaoImpl();
			Menu i = m.getMenubyId(2);
			System.out.println(i);
		}
}


