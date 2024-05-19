<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.food.model.Menu" %>
<%@ page import="com.food.model.Restaurants" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu Items</title>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css">
    <link rel="stylesheet" href="z.css"> <!-- Link your CSS file here -->
     <style>
	     
	      body {
            background-color: #E3B448; /* Set background color */
            font-family: Arial, sans-serif; /* Specify font */
            margin: 0; /* Remove default margin */
            padding: 0; /* Remove default padding */
        }
        .nav {
            background-color: #333; /* Set navigation background color */
            color: #fff; /* Set navigation text color */
            padding: 10px 0; /* Add padding to navigation */
            text-align: center; /* Center-align navigation items */
        }
        .nav ul {
            list-style-type: none; /* Remove bullet points */
            padding: 0; /* Remove default padding */
            margin: 0; /* Remove default margin */
        }
        .nav ul li {
            display: inline; /* Display navigation items inline */
            margin-right: 20px; /* Add spacing between navigation items */
        }
        .nav ul li a {
            text-decoration: none; /* Remove underline from links */
            color: #fff; /* Set link color */
            padding: 10px 20px; /* Add padding to links */
            border-radius: 5px; /* Add border radius to links */
            transition: background-color 0.3s ease; /* Add transition effect */
        }
        .nav ul li a:hover {
            background-color: #555; /* Change background color on hover */
        }
        /* Rest of your styles remain unchanged */
        .restaurant-info {
            padding: 20px;
            margin-top: 20px;
            margin-left:250px;
            margin-right:250px;
            
        }
        .restaurant-info p {
            margin: 5px ;
            margin-left:20px:
            
            font-weight: 200;
        }
        .menu-container {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            padding: 20px;
        }
        .menu-item {
            width: 300px;
            margin: 20px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s ease-in-out;
        }
        .menu-item:hover {
            transform: translateY(-5px);
        }
        .menu-item img {
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-radius: 8px;
            margin-bottom: 10px;
        }
        .menu-item-info h3 {
            margin: 0;
            color: #333;
        }
        .menu-item-info p {
            margin: 5px 0;
            color: #888;
        }
    </style>
</head>
<body>
<section class="menu">
    <div class="nav">
        <header>
            <div class="logo"><h1>TapFoods</h1></div>
        </header>
        <ul>
            <li><a href="index.jsp"><i class='bx bxs-home-smile'></i> Home</a></li>
            <li><a href="SearchServlet"><i class='bx bx-search'></i> Search</a></li>
            <li><a href="cart.jsp"><i class='bx bxs-cart-add'></i> Cart</a></li>
            <li><a href="favorate.jsp"><i class='bx bxs-heart-circle'></i> Fav</a></li>
            <li><a href="profile.jsp"><i class='bx bxs-user'></i> Profile</a></li>
        </ul>
    </div>
</section>

<div class="restaurant-info">
    <% Restaurants restaurant = (Restaurants) request.getAttribute("resturantDetails");
       if (restaurant != null) {%>
           
                <h3><%= restaurant.getName() %><span style="margin-left: 600px;"><i class='bx bxs-star' style="color: rgb(224, 161, 23);"><%= restaurant.getRating() %></i></h3>
    			<p style="font-size: 12px;"><%= restaurant.getCuisineType() %></p>
    			<p style="font-size: 12px;"><%=restaurant.getAddress() %></p>
   				<p><i class='bx bx-time' style="font-size: 12px;"><%= restaurant.getDeliveryTime() %></i></p>
		   <% } %>
<hr style="border:none;height:1px;background-color: #f0f0f0; margin-top: 20px; margin-bottom: 20px; border-style: dotted; border-color: #ccc; border-width: 1.3px;">
		   
</div>
      
<h3 style="margin-left:270px; margin-right:250px;">Recomended</h3>
<div class="menu-container">
<%
    List<Menu> menuList = (List<Menu>) request.getAttribute("menu");
    if (menuList != null && !menuList.isEmpty()) {
        for (Menu menu : menuList) {
%>
<div class="menu-item">
   <%--  <img src="<%= menu.getImagePath() %>" alt="Menu Item">--%>
   <img src="download3.jpeg"  alt="menu Item">
    <div class="menu-item-info">
        <h3><%= menu.getItemName() %></h3>
        <p><i class='bx bx-rupee'></i> <%= menu.getPrice() %> | <%= menu.getDescription() %></p>
        <p><i class='bx bx-time'></i> <%= menu.getIsAvailable() %></p>
       <a href="CartServlet?menuid=<%= menu.getMenuId() %>"   > <button type="submit">Add to cart</button></a>
    </div>
</div>
<%
        }
    } else {
%>
<p>No menu items found.</p>
<%
    }
%>
</div>
<hr style="border:none;height:1px;background-color: rgb(227, 227, 219); margin-top: 20px;margin-left:250px; margin-right:250px;">

</body>
</html>