package com.food.Daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Dao.RestaurantDao;
import com.food.model.Restaurants;

public class RestaurantDaoImpl implements RestaurantDao{
	String INSERT_QUERY="INSERT into `restaurants`(`restaurantId`,`name`,`cuisineType`, `deliveryTime`, `address`, `adminUserId`,`rating`,`isActive`,`imagePath`) VALUES(?,?,?,?,?,?,?,?,?)";
	String SELECT_QUERY="SELECT * FROM `restaurants` WHERE `restaurantId` = ?";
	String UPDATE_QUERY="UPDATE `restaurants` SET `name` = ?, `cuisineType` = ?, `deliveryTime` = ?, `address` = ?, `adminUserId` = ?, `rating`,`isActive`,`imagePath`, WHERE `restaurantId` = ?";
	String DELETE_QUERY="DELETE FROM `restaurants` WHERE `restaurantId` = ?";
	String SELECT_ALL_QUERY="SELECT * FROM `restaurants`";
	String SEARCH_QUERY="SELECT * FROM `restaurants` WHERE `name`=?";

	
	private Connection connection;
	
	public RestaurantDaoImpl(){
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
	public int addRestaurant(Restaurants restaurant) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(INSERT_QUERY);
			 statement.setInt(1, restaurant.getRestaurantId());
			 statement.setString(2, restaurant.getName());
			 statement.setString(3, restaurant.getCuisineType());
			 statement.setInt(4, restaurant.getDeliveryTime());
			 statement.setString(5, restaurant.getAddress());
			 statement.setInt(6, restaurant.getAdminUserId());
			 statement.setFloat(7, restaurant.getRating());
			 statement.setString(8, restaurant.isActive());
			 statement.setString(9, restaurant.getImagePath());
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return 0;
	}

	@Override
	public Restaurants getRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		ResultSet res=null;
		 try {
			statement = connection.prepareStatement(SELECT_QUERY);
			statement.setInt(1, restaurantId);
			 res = statement.executeQuery();
			 if(res.next()) {
				 String name = res.getString("name");
				 String cuisineType = res.getString("cuisineType");
				 int deliveryTime = res.getInt("deliveryTime");
				 String address = res.getString("address");
				 int adminUserId = res.getInt("adminUserId");
				 float rating = res.getFloat("rating");
				 String isActive = res.getString("isActive");
				 
				 Restaurants restaurants = new Restaurants(restaurantId, name, cuisineType, deliveryTime, address, adminUserId, rating, isActive, isActive);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateRestaurant(Restaurants restaurant) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(UPDATE_QUERY);
			 statement.setString(1, restaurant.getName());
			 statement.setString(2, restaurant.getCuisineType());
			 statement.setInt(3, restaurant.getDeliveryTime());
			 statement.setString(4, restaurant.getAddress());
			 statement.setInt(5, restaurant.getAdminUserId());
			 statement.setFloat(6, restaurant.getRating());
			 statement.setString(7, restaurant.isActive());
			 statement.setString(8, restaurant.getImagePath());
			 statement.setInt(9, restaurant.getRestaurantId());
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(DELETE_QUERY);
			 statement.setInt(1, restaurantId);
			  statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Restaurants> getAllRestaurants() {
		// TODO Auto-generated method stub
		Statement statement=null;
		ResultSet res=null;
		Restaurants restaurants =null;
		ArrayList<Restaurants> RestaurantList = new ArrayList<Restaurants>();
		try {
			 statement = connection.createStatement();
			   res = statement.executeQuery(SELECT_ALL_QUERY);
			   while(res.next()) {
			   int i = res.getInt("restaurantId");
			   String name = res.getString("name");
			   String cuisineType = res.getString("cuisineType");
			   int deliveryTime = res.getInt("deliveryTime");
			   String address = res.getString("address");
			   int adminUserId = res.getInt("adminUserId");
			   float rating = res.getFloat("rating");
			   String isActive = res.getString("isActive");
			   String imagePath = res.getString("imagePath");
                     restaurants  = new Restaurants(i, name, cuisineType, deliveryTime, address, adminUserId, rating, isActive, imagePath);			    
			    RestaurantList.add(restaurants);
			   } 
			    return RestaurantList;
			    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}




	@Override
	public Restaurants searchRestaurant(String  name) {
		// TODO Auto-generated method stub
		ResultSet res=null;
		try {
			PreparedStatement statement = connection.prepareStatement(SEARCH_QUERY);
			statement.setString(1, name);
			 res = statement.executeQuery();
			 while(res.next()) {
				 Restaurants i = new Restaurants(res.getInt(1),res.getString(2),res.getString(3),res.getInt(4),res.getString(5),res.getInt(6),res.getFloat(7),res.getString(8),res.getString(9));
			    System.out.println(i);
			    return  i;
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

}
