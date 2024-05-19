package com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.Daoimpl.MenuDaoImpl;
import com.food.Daoimpl.RestaurantDaoImpl;
import com.food.model.Menu;
import com.food.model.Restaurants;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     
		
		      MenuDaoImpl m = new MenuDaoImpl();
		    Integer  r = Integer.parseInt(req.getParameter("rId"));
		     List<Menu> menu = m.getMenu(r);
		     RestaurantDaoImpl restaurant = new RestaurantDaoImpl();
		     Restaurants restaurantdetails = restaurant.getRestaurant(r);
		     req.setAttribute("menu", menu);
		     req.setAttribute("restaurantdetails", restaurantdetails);
		     RequestDispatcher rd = req.getRequestDispatcher("Menu.jsp");
		     rd.forward(req, resp);
		
		
	}

}
