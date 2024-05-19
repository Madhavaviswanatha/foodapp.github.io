package com.food.Daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.food.Dao.OrderitemsDao;
import com.food.model.Orderitems;

public class OrderitemsDaoImpl implements OrderitemsDao{
	private final String INSERT_QUERY="INSERT INTO `orderitems` (`orderItemId`, `orderId`, `menuId`, `itemName`, `quantity`, `itemTotal`, `itemPrice`) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private final String SELECT_QUERY="SELECT * FROM `orderitems` WHERE `orderItemId` = ?";
	private final String UPDATE_QUERY="UPDATE `orderitems` SET `orderId` = ?, `menuId` = ?, `itemName` = ?, `quantity` = ?, `itemTotal` = ?, `itemPrice` = ? WHERE `orderItemId` = ?";
	private final String DELETE_QUERY="DELETE FROM `orderitems` WHERE `orderItemId` = ?";
			
	private final String SELECT_ALL_QUERY="SELECT * FROM `orderitems`";
	
	
	
	
	private Connection connection;
	
	public OrderitemsDaoImpl(){
		
		
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
	public void addOrderitems(Orderitems orderitems) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(INSERT_QUERY);
			 statement.setInt(1, orderitems.getOrderItemId());
			 statement.setInt(2, orderitems.getOrderId());
			 statement.setInt(3, orderitems.getMenuId());
			 statement.setString(4, orderitems.getItemName());
			 statement.setInt(5, orderitems.getQuantity());
			 statement.setInt(6, orderitems.getItemTotal());
			 statement.setFloat(7, orderitems.getItemPrice());
			 int i = statement.executeUpdate();
			 System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Orderitems getOrderitems(int orderitemsId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		ResultSet res=null;
		try {
			 statement = connection.prepareStatement(SELECT_QUERY);
			 statement.setInt(1, orderitemsId);
			  res = statement.executeQuery();
			  while(res.next()) {
				  Orderitems oi = new Orderitems(res.getInt(1), res.getInt(2), res.getInt(3), res.getString(4), res.getInt(5),res.getInt(6), res.getFloat(7));
				  System.out.println(oi);
				  return oi;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrderitems(Orderitems orderitems) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(UPDATE_QUERY);
			 statement.setInt(1, orderitems.getOrderId());
			 statement.setInt(2, orderitems.getMenuId());
			 statement.setString(3, orderitems.getItemName());
			 statement.setInt(4, orderitems.getQuantity());
			 statement.setInt(5, orderitems.getItemTotal());
			 statement.setFloat(6, orderitems.getItemPrice());
			 statement.setInt(7, orderitems.getOrderItemId());
			int i = statement.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderitems(int orderitemsId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(DELETE_QUERY);
			 statement.setInt(1, orderitemsId);
			 int i = statement.executeUpdate();
			 System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Orderitems> getAllOrderitems() {
		// TODO Auto-generated method stub
		Statement statement=null;
		ResultSet res=null;
		ArrayList<Orderitems> oritemsList = new ArrayList<Orderitems>();
		try {
			 statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  while(res.next()) {
				  Orderitems oi = new Orderitems(res.getInt(1),res.getInt(2),res.getInt(3),res.getString(4),res.getInt(5),res.getInt(6),res.getFloat(7));
			  
				  oritemsList.add(oi);
			  
			  }
			  return oritemsList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
