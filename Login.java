package com.food.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.food.model.Users;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		
		System.out.println("email" + email);
		System.out.println("pass"+ pass);
		String url="jdbc:mysql://localhost:3306/food_app";
		String username="root";
		String password="Madhava";
		String sql="SELECT * FROM `users` WHERE `email`=? AND `password`=?";
		Connection connection;
		PreparedStatement statement;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			 connection = DriverManager.getConnection(url,username,password);
			  statement = connection.prepareStatement(sql);
			  statement.setString(1, email);
			  statement.setString(2, pass);
			  ResultSet n = statement.executeQuery();
			   System.out.println("user got"+n);
			   if(n.next()) {
				      Users u = new Users();
				      u.setUserName(n.getString("userName"));
				      HttpSession session = req.getSession();
				      session.setAttribute("username", u);
				   String r = n.getString("email");
				   System.out.println(r);
				   System.out.println("sucess");
				   RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				   rd.forward(req, resp);
			   }
			   else {
				   System.out.println("failed");
				   RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
				   req.setAttribute("error","Invalid username or password");
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
