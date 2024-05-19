package com.food.Daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Dao.OrdersDao;
import com.food.model.Orders;

public class OrdersDaoImpl implements OrdersDao{
	
	
	private final String INSERT_QUERY="INSERT into `orders`(`orderId`,`userId`,`restaurantId`, `orderDate`, `totalAmount`, `status`,`paymentMethod`) VALUES(?,?,?,?,?,?,?)";
	private final String SELECT_QUERY="SELECT * FROM `orders` WHERE `orderId` = ?";
	private final String UPDATE_QUERY="UPDATE `orders` SET `userId` = ?, `restaurantId` = ?, `orderDate` = ?, `totalAmount` = ?, `status` = ?, `paymentMethod`, WHERE `orderId` = ?";
	private final String DELETE_QUERY="DELETE FROM `orders` WHERE `orderId` = ?";
	private final String SELECT_ALL_QUERY="SELECT * FROM `orders`";
	
	
	
	
	
	
	private Connection connection=null;
	
	public OrdersDaoImpl(){
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
	public void addOrders(Orders order) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(INSERT_QUERY);
			 statement.setInt(1, order.getOrderId());
			 statement.setInt(2, order.getUserId());
			 statement.setInt(3, order.getRestaurantId());
			 statement.setDate(4, (Date) order.getOrderDate());
			 statement.setFloat(5, order.getTotalAmount());
			 statement.setString(6, order.getStatus());
			 statement.setString(7, order.getPaymentMethod());
			 int i = statement.executeUpdate();
			 System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Orders getOrders(int orderId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		ResultSet res=null;
		try {
			 statement = connection.prepareStatement(SELECT_QUERY);
			 statement.setInt(1, orderId);
			  res = statement.executeQuery();
			  while(res.next()) {
				  Orders orders = new Orders();
				  orders.setOrderId(res.getInt("orderId"));
				  orders.setUserId(res.getInt("userId"));
				  orders.setRestaurantId(res.getInt("restaurantId"));
				  orders.setOrderDate(res.getDate("orderDate"));
				  orders.setTotalAmount(res.getFloat("totalAmount"));
				  orders.setStatus(res.getString("status"));
				  orders.setPaymentMethod(res.getString("paymentMethod"));
				  return orders;
				  
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateOrders(Orders order) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(UPDATE_QUERY);
			 statement.setInt(1, order.getUserId());
			 statement.setInt(2, order.getRestaurantId());
			 statement.setDate(3, (Date) order.getOrderDate());
			 statement.setFloat(4, order.getTotalAmount());
			 statement.setString(5, order.getStatus());
			 statement.setString(6, order.getPaymentMethod());
			 statement.setInt(7, order.getOrderId());
			 int i = statement.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrders(int orerId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(DELETE_QUERY);
			 statement.setInt(1, orerId);
			 int i = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		Statement statement=null;
		ResultSet res=null;
		ArrayList<Orders> ordersList = new ArrayList<Orders>();
		try {
			   statement = connection.createStatement();
			    res = statement.executeQuery(SELECT_ALL_QUERY);
			    while(res.next()) {
			    	Orders orders = new Orders();
			    	orders.setOrderId(res.getInt("orderId"));
			    	orders.setUserId(res.getInt("orderId"));
			    	orders.setRestaurantId(res.getInt("restaurantId"));
			    	orders.setOrderDate(res.getDate("orderDate"));
			    	orders.setTotalAmount(res.getFloat("totalAmount"));
			    	orders.setStatus(res.getString("status"));
			    	orders.setPaymentMethod(res.getString("paymentMethod"));
			    	ordersList.add(orders);
			    }
			    return ordersList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

}
