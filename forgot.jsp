<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        /* Add some basic styling for the form */
        body {
            /* background-color: aquamarine; */
            /* background-attachment: fixed; */
            background-image: url("image1.jpg");
        }

        form {
            width: 300px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            box-shadow: 0px 0px 10px 1px rgba(0, 0, 0, 0.1);
            background-color: antiquewhite;
        }

        h1 {
            text-align: center;
            width: 85%;
            padding: 10px;
        }

        label {
            display: block;
            margin-top: 10px;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-top: 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }

        .back-to-login {
            text-align: center;
            margin-top: 20px;
        }

        .back-to-login a {
            text-decoration: none;
            color: blue;
        }
    </style>
</head>
<body>
    <form id="forgot-password-form">
        <h1>Forgot Password</h1>
        <label for="email">Enter your email address:</label>
        <input type="email" id="email" name="email" required>

        <label for="new-password">Enter a new password:</label>
        <input type="password" id="new-password" name="new-password" required>

        <label for="confirm-password">Confirm your new password:</label>
        <input type="password" id="confirm-password" name="confirm-password" required>

        <input type="submit" value="Submit">
    </form>

    <div class="back-to-login">
        <a href="Login.jsp">Back to Login</a>
    </div>

    <script>
        // You can add JavaScript to handle form submission and other functionalities.
        document.getElementById('forgot-password-form').addEventListener('submit', function (event) {
            event.preventDefault();

            // Get the new password and confirmation password input fields
            constPasswordInput = document.getElementById('new-password');
            const confirmPasswordInput = document.getElementById('confirm-password');

            // Check if the new password and confirmation password match
            if (newPasswordInput.value !== confirmPasswordInput.value) {
                alert('The new password and confirmation password do not match.');
                return;
            }

            // You can add code here to handle the form submission, e.g., send a request to the server for password recovery.
            // This is just a basic example without actual functionality.

            alert("A password recovery email has been sent to your email address.");
        });
    </script>
</body>
</html>