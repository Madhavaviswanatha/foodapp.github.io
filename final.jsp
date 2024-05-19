<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
        button[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        button[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <%-- Order Confirmation Section --%>
    <div class="container">
        <h2>Order Confirmation</h2>
        <%-- Add your order confirmation logic here --%>
        <p>Your order has been confirmed. Thank you for shopping with us!</p>
        
        <%-- Displaying timing of the order --%>
        <%@ page import="java.text.SimpleDateFormat" %>
        <%@ page import="java.util.Date" %>
        <% Date now = new Date(); %>
        <% SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"); %>
        <p>Order placed at: <%= sdf.format(now) %></p>
        
        <%-- Calculating arriving time --%>
        <% int deliveryTimeInHours = 48; // Example: 48 hours delivery time %>
        <% long deliveryTimeInMillis = deliveryTimeInHours * 60 * 60 * 1000; %>
        <% Date arrivingTime = new Date(now.getTime() + deliveryTimeInMillis); %>
        <p>Your item is expected to arrive by: <%= sdf.format(arrivingTime) %></p>
    </div>

</body>
</html>
