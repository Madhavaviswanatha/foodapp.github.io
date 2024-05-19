package com.food.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.model.CartCreator;


@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CheckoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CartCreator cart = (CartCreator)request.getSession().getAttribute("cart");
		if(cart!=null ) {
			System.out.println("checkout successul");
			
			response.sendRedirect("Checkout.jsp");
		}else {
			response.sendRedirect("cart.jsp?error=empty_cart");
		}
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        doGet(request, response);

}
}
