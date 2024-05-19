package com.food.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.Daoimpl.RestaurantDaoImpl;
import com.food.model.Restaurants;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		          String name = request.getParameter("search_query");
		          RestaurantDaoImpl search = new RestaurantDaoImpl();
		        Restaurants searchRestaurant = search.searchRestaurant(name);
		        request.setAttribute("A", searchRestaurant);
		        
		          
RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
rd.forward(request, response);
	
	}

}
