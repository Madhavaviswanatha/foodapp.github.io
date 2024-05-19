<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.food.model.*,com.food.Daoimpl.RestaurantDaoImpl" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Restaurant List</title>
    <link rel="stylesheet" href="z.css">
    <link rel="stylesheet" href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'>
<style>
header {
    color: #EE4E34;
    padding: 10px 50px;
}

.restaurant-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    padding: 50px;
    transition: transform 0.3s ease-in-out;
}

.restaurant-card {
    width: 250px;
    margin-bottom: 20px;
    border: 1px solid #ccc;
    border-radius: 8px;
    box-shadow: 0 0 10px black;
    transition: transform 0.3s ease-in-out;
}

.restaurant-card img {
    width: 100%;
    height: 200px;
    object-fit: cover;
    border-top-left-radius: 5px;
    border-top-right-radius: 5px;
}

.restaurant-details {
    padding: 10px;
}

.restaurant-details h3 {
    margin-top: 0;
}

.restaurant-details p {
    margin: 5px 0;
}

.nav {
    background-color: #FCEDDA;
    color: #fff;
    padding: 10px 0;
    text-align: center;
}

.nav ul {
    list-style-type: none;
    padding: 0;
    margin: 0;
    text-align: center;
}

.nav ul li {
    display: inline-block;
    margin-right: 30px;
}

.nav ul li a {
    text-decoration: none;
    color: #73605B;
}

.nav ul li a:hover {
    text-decoration: underline;
}
.nav ul li h3{
  color:red;
  width: 30%; 
  top: 10%; 
   position: absolute; 
   left: 50%; 
   border-bottom: 5px solid white; 
     overflow: hidden; 
     animation: animate 2s linear forwards;
     
}
 @keyframes animate { 
                0% { 
                    width: 0px; 
                    height: 0px; 
                } 
  
                30% { 
                    width: 50px; 
                    height: 0px; 
                } 
  
                60% { 
                    width: 50px; 
                    height: 80px; 
                } 
            } 
     

footer {
    background-color: rgb(227, 227, 219);
    width: 100%;
    color: green;
    text-align: center;
    padding: 2px;
}
</style>
</head>
<body>
<section class="menu">
    <div class="nav">
        <header><div class="logo"><h1>Welcome to buddy Foods</h1></div></header>
        <%
           Users username=(Users)session.getAttribute("username");
%>
                
        <ul>
            <li><a href="index.jsp"><i class='bx bxs-home-smile'>Home</i></a></li>
            <li><a href="cart.jsp"><i class='bx bxs-cart-add'></i>Cart</a></li>
            <li><a href="favorate.jsp"><i class='bx bxs-heart-circle'></i>Fav</a></li>
            <li><a href="profile.jsp"><i class='bx bxs-user'></i>Profile</a></li>
            <% if(username == null) { %>
                <li><a href="signup.jsp"><i class='bx bxs-user'></i>Sign-up</a></li>
                <li><a href="Login.jsp"><i class='bx bxs-user'></i>Login</a></li>
            <% } else { %>
                <li><h3>Welcome <%= username.getUserName() %></h3></li>
                <li><a href="Logout"><i class='bx bxs-user'></i>Logout</a></li>
            <% } %>
        </ul>
    </div>
</section>
<header>
         <form action="SearchServlet" method="GET">
        <input type="text" name="search_query" placeholder="Search by name, cuisine, etc.">
        <button type="submit">Search</button>
    </form>
    

    <h2>Top Restaurants in Bangalore</h2>
</header>

 <main>
<form action="Restaurant"></form> 
    <div class="restaurant-list">
        <% 
        RestaurantDaoImpl r = new RestaurantDaoImpl();
        List<Restaurants> al = r.getAllRestaurants();
        request.setAttribute("restaurant", al);
        List<Restaurants> restaurants = (List<Restaurants>) request.getAttribute("restaurant");
           if (restaurants != null) {
               for (Restaurants restaurant : restaurants) { %>
                <a href="MenuServlet?rId=<%= restaurant.getRestaurantId() %>" style="text-decoration: none; color:black;">
                   <div class="restaurant-card">
                   <img src="download.jpg" alt="Restaurant Image">
                       <div class="restaurant-details">
                           <h3><%= restaurant.getName() %></h3>
                           <p> <i class='bx bxs-calendar-star'><%= restaurant.getRating() %></i>. <%= restaurant.getCuisineType() %> , <%= restaurant.getAddress() %></p>
                           <pre> <i class='bx bx-time-five'><%= restaurant.getDeliveryTime() %></i>  <%= restaurant.isActive() %></pre>
                       </div>
                   </div>
                </a>
        <%      } 
           } %>
    </div>

</main>

<footer>
    <p>&copy; 2024 TapFoods. All rights reserved.</p>
</footer>
</body>
</html>
