package com.food.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.food.Daoimpl.MenuDaoImpl;
import com.food.model.CartCreator;
import com.food.model.Cartitem;
import com.food.model.Menu;
import java.util.Map;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CartServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("menuid") != null) {
            int min = 1;
            Integer menuid = Integer.parseInt(request.getParameter("menuid"));

            MenuDaoImpl mdi = new MenuDaoImpl();
            Menu menu = mdi.getMenubyId(menuid);

            Cartitem cartitem = new Cartitem(menu.getMenuId(),
                    menu.getRestaurantId(),
                    menu.getItemName(),
                    menu.getPrice(),
                    min);

            CartCreator cart = (CartCreator) request.getSession().getAttribute("cart");
            if (cart == null) {
                cart = new CartCreator();
                request.getSession().setAttribute("cart", cart);
            }
            cart.addCartitem(cartitem);

            Map<Integer, Cartitem> cartItems = cart.getCartItems();
            request.setAttribute("cartItems", cartItems);

            request.getRequestDispatcher("cart.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            if (action.equals("update")) {
                updateCartitem(request, response);
            } else if (action.equals("remove")) {
                removeCartitem(request, response);
            } else {
                response.sendRedirect("cart.jsp");
            }
        }
    }

    protected void updateCartitem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int itemId = Integer.parseInt(req.getParameter("itemId"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        CartCreator cart = (CartCreator) req.getSession().getAttribute("cart");
        if (cart != null) {
            cart.updateCartitem(itemId, quantity);
        }
        resp.sendRedirect("CartServlet");
    }


    protected void removeCartitem(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));

        CartCreator cart = (CartCreator) request.getSession().getAttribute("cart");
        if (cart != null) {
            cart.removeCartitem(itemId);
        }

        response.sendRedirect("cart.jsp");
    }
}
