<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="com.food.model.*" %>
<html>
<head>
    <title>Shopping Cart</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }

        .card {
            background-color: #ffffff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-bottom: 20px;
            overflow: hidden;
        }

        .card-body {
            padding: 20px;
        }

        .card-title {
            font-size: 20px;
            font-weight: bold;
            margin-bottom: 10px;
            color: #343a40;
        }

        .card-info {
            margin-bottom: 10px;
            color: #6c757d;
        }

        .card-price {
            font-size: 18px;
            font-weight: bold;
            color: #007bff;
        }

        .card-actions {
            text-align: right;
            margin-top: 10px;
        }

        .btn {
            background-color: #007bff;
            color: #ffffff;
            border: none;
            padding: 8px 16px;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
        }

        .btn:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Shopping Cart</h1>
    <div class="container">
        <% 
            // Retrieve cartItems from request attribute
            Map<Integer, com.food.model.Cartitem> cartItems = (Map<Integer, com.food.model.Cartitem>) request.getAttribute("cartItems");
            if (cartItems != null) {
                for (com.food.model.Cartitem item : cartItems.values()) {
        %>
        <div class="card">
            <div class="card-body">
                <h2 class="card-title"><%= item.getItemName() %></h2>
                <p class="card-info">Price: $<span class="card-price"><%= item.getPrice() %></span></p>
                <p class="card-info">Quantity: <%= item.getQuantity() %></p>
                <div class="card-actions">
                    <form action="CartServlet" method="Post">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="number" name="quantity" value="<%= item.getQuantity() %>">
                        <input type="submit" class="btn" value="Update">
                    </form>
                    
                    
                    
                    <a href="CartServlet?action=remove&itemId=<%= item.getItemId() %>" class="btn">Remove</a>
                </div>
            </div>
        </div>
    <a href="MenuServlet?rId=<%=item.getRestaurantId() %>">Add More Items</a><br>
        <% 
                }
            }
        %>
    </div>
    <a href="CheckoutServlet" class="btn">Proceed to checkout</a>
</body>
</html>
