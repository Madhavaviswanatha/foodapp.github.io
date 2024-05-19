package com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.Daoimpl.RestaurantDaoImpl;
import com.food.model.Restaurants;

@WebServlet("/Restaurant")
public class Restaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Restaurant() {

        super();
    }

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDaoImpl r = new RestaurantDaoImpl();
        List<Restaurants> al = r.getAllRestaurants();
        System.out.println(al);
        req.setAttribute("restaurant", al);
        RequestDispatcher re = req.getRequestDispatcher("index.jsp");
        re.forward(req, resp);
	}

	
}
