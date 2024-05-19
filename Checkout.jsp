<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
    <title>Checkout Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2; /* Background color for the body */
            background-image: url('think.jpg'); /* Add a background image to the container */
            background-size: cover;
            
            margin: 0;
            padding: 0;
        }

       .container {
            width: 50%;
            margin: 50px auto;
         
            background-color: #fff; /* Background color for the form container */
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            text-align: center;
        }

        input[type="text"],
        input[type="number"],
        select {
            width: 80%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        button[type="submit"] {
            background-color: #4CAF50; /* Green */
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button[type="submit"]:hover {
            background-color: #45a049; /* Darker Green */
        }

        /* Additional styles for adding color */
        label {
            color: #4CAF50; /* Green */
        }

        select {
            background-color: #f2f2f2; /* Light Gray */
        }

        option {
            background-color: #fff; /* White */
        }

        /* Modified styles for adding color */
       .container {
            background-color: #e6f7ff; /* Light Blue */
        }

        h1 {
            color: #007bff; /* Darker Blue */
        }

        label {
            color: #dc3545; /* Red */
        }

        select {
            background-color: #fff; /* White */
        }

        option {
            background-color: #e6f7ff; /* Light Blue */
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Checkout Form</h1>
        <form action="final.jsp" method="post">
            <label for="address">Address:</label><br />
            <input type="text" id="address" name="address" required /><br /><br />
            <label for="number">Number:</label><br />
<input type="number" id="number" name="number" required min="1000000000" max="9999999999" pattern="[0-9]{10}" title="Please enter a 10-digit valid number" /><br></br>
            <label for="paymentMode">Payment Mode:</label><br />
            <select name="paymentMode">
                <option value="creditCard">Credit Card</option>
                <option value="debitCard">Debit Card</option>
                <option value="netBanking">Net Banking</option>
                <option value="paypal">PayPal</option>
            </select><br /><br />
            <button type="submit">Confirm</button>
        </form>
    </div>
</body>
</html>