package com.food.Daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.food.Dao.UserDao;
import com.food.model.Users;

public class UserDaoImpl implements UserDao{
	
	String INSERT_QUERY="INSERT into `users`(`userId`,`userName`,`password`, `email`, `address`, `role`) VALUES(?,?,?,?,?,?)";
	String SELECT_QUERY="SELECT * FROM `users` WHERE `userId` = ?";
	String UPDATE_QUERY="UPDATE `users` SET `userName` = ?, `password` = ?, `email` = ?, `address` = ?, `role` = ?,  WHERE `userId` = ?";
	String DELETE_QUERY="DELETE FROM `users` WHERE `userId` = ?";
	String SELECT_ALL_QUERY="SELECT * FROM `users`";

	
	private Connection connection=null;
	
	public UserDaoImpl(){
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
	public int addUser(Users user) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(INSERT_QUERY);
			 statement.setInt(1, user.getUserId());
			 statement.setString(2, user.getUserName());
			 statement.setString(3, user.getPassword());
			 statement.setString(4, user.getEmail());
			 statement.setString(5, user.getAddress());
			  statement.setString(6, user.getRole());
			  int i = statement.executeUpdate();
			  System.out.println(i);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public Users getUser(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		ResultSet res=null;
		
		try {
			 statement = connection.prepareStatement(SELECT_QUERY);
			 statement.setInt(1, userId);
			  res = statement.executeQuery();
			  if(res.next()) {
				  int i = res.getInt("userId");
				  String userName = res.getString("userName");
				  String password = res.getString("password");
				  String email = res.getString("email");
				  String address = res.getString("address");
				  String role = res.getString("role");
				  Users users = new Users(userId, userName, password, email, address, role);
			    
			      return users;
			  }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateUser(Users user) {
		PreparedStatement statement=null;
		// TODO Auto-generated method stub
		 try {
			statement = connection.prepareStatement(UPDATE_QUERY);
			statement.setString(1, user.getUserName());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getAddress());
			statement.setInt(5, user.getUserId());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		PreparedStatement statement=null;
		try {
			 statement = connection.prepareStatement(DELETE_QUERY);
			 statement.setInt(1, userId);
			 statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	

	@Override
	public List<Users> getAllUser() {
		// TODO Auto-generated method stub
		Statement statement=null;
		ResultSet res=null;
		ArrayList<Users> userList = new ArrayList<Users>();
		
		try {
			 statement = connection.createStatement();
			  res = statement.executeQuery(SELECT_ALL_QUERY);
			  if(res.next()) {
				  int i = res.getInt("userId");
				  String userName = res.getString("userName");
				  String password = res.getString("password");
				  String email = res.getString("email");
				  String address = res.getString("address");
				  String role = res.getString("role");
				  Users users = new Users(i, userName, password, email, address, role);
			  userList.add(users);
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return userList;
	}
	public static void main(String[] args) {
		Users users = new Users(4, "kiran", " kirankv", "kiran@123Gmail.com", "kogigal", "customer");
		
		UserDaoImpl i = new UserDaoImpl();
		i.addUser(users);
		
		
	}

}
