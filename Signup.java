package com.food.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String url="jdbc:mysql://localhost:3306/food_app";
		String username="root";
		String password="Madhava";
		String sql="INSERT into `users`(`userName` , `password` , `email`)VALUES(?,?,?)";
		Connection connection;
		PreparedStatement statement;
             try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				 connection = DriverManager.getConnection(url,username,password);
				  statement = connection.prepareStatement(sql);
				  statement.setString(1,req.getParameter("name"));
				  statement.setString(2, req.getParameter("password"));
				  statement.setString(3, req.getParameter("email"));
				  int m = statement.executeUpdate();
				  System.out.print(m);
				  if(m>0) {
					  RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
					  rd.forward(req, resp);
				  }
				 
				
				
				
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
