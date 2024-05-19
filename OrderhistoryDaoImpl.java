package com.food.Daoimpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.food.Dao.OrderhistoryDao;
import com.food.model.Orderhistory;

public class OrderhistoryDaoImpl implements OrderhistoryDao{
	private final String INSERT_QUERY="INSERT into `orderhistory`(`orderHistoryId`,`userId`,`orderId`, `orderDate`, `totalAmount`, `status`) VALUES(?,?,?,?,?,?)";
	private final String SELECT_QUERY="SELECT * FROM `orderhistory` WHERE `orderHistoryId` = ?";
	private final String UPDATE_QUERY="UPDATE `orderhistory` SET `userId` = ?, `orderId` = ?, `orderDate` = ?, `totalAmount` = ?, `status` = ?,  WHERE `orderHistoryId` = ?";
	private final String DELETE_QUERY="DELETE FROM `orderhistory` WHERE `orderHistoryId` = ?";
	private final String SELECT_ALL_QUERY="SELECT * FROM `orderhistory`";
	
	
	private Connection connection;
	public OrderhistoryDaoImpl(){
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
	public void addOrderhistory(Orderhistory orderhistory) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;

		
		try {
			 statement = connection.prepareStatement(INSERT_QUERY);
			 statement.setInt(1, orderhistory.getOrderHistoryId());
			 statement.setInt(2, orderhistory.getUserId());
			 statement.setInt(3, orderhistory.getOrderId());
			 statement.setDate(4, (Date) orderhistory.getOrderDate());
			 statement.setDouble(5, orderhistory.getTotalAmount());
			 statement.setString(6, orderhistory.getStatus());
			 int i = statement.executeUpdate();
			 System.out.println(i);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Orderhistory getOrderhistory(int orderhistoryId) {
		// TODO Auto-generated method stub
		ResultSet res=null;
		PreparedStatement statement=null;

		try {
			 statement = connection.prepareStatement(SELECT_QUERY);
			 statement.setInt(1, orderhistoryId);
			  res = statement.executeQuery();
			  if(res.next()) {
				 Orderhistory oh = new Orderhistory(res.getInt(1),res.getInt(2),res.getInt(3),res.getDate(4),res.getDouble(5),res.getString(6));
			 
			  System.out.println(oh);
			  return oh;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateOrderhistrory(Orderhistory orderhistory) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = connection.prepareStatement(UPDATE_QUERY);
			pstmt.setInt(1, orderhistory.getUserId());
			pstmt.setInt(2, orderhistory.getOrderId());
			pstmt.setDate(3, (Date) orderhistory.getOrderDate());
			pstmt.setDouble(4, orderhistory.getTotalAmount());
			pstmt.setString(5, orderhistory.getStatus());
			pstmt.setInt(6, orderhistory.getOrderHistoryId());
			int i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteOrderhistrory(int orderhistroryId) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
			statement.setInt(1, orderhistroryId);
			int i = statement.executeUpdate();
			System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Orderhistory> getAllOrderhistory() {
		// TODO Auto-generated method stub
		ResultSet res=null;
		ArrayList<Orderhistory> orhList = new ArrayList<Orderhistory>();
		try {
			Statement statement = connection.createStatement();
			 res = statement.executeQuery(SELECT_ALL_QUERY);
			 while(res.next()) {
				 Orderhistory oh = new Orderhistory(res.getInt(1),res.getInt(2),res.getInt(3),res.getDate(4),res.getDouble(5),res.getString(6));
			    orhList.add(oh);
			 }
			 return orhList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
