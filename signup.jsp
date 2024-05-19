<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Sign-up from</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <style>
        /* Add some basic styling for the form */
        body {
          background-image: url("pexels-johannes-plenio-1103970.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
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

        input[type="text"],
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

        .or-text {
            text-align: center;
            margin-top: 20px;
            margin-bottom: 20px;
            font-weight: bold;
        }

        .signup-text {
            text-align: center;
            margin-top: 10px;
            font-weight: bold;
        }

        /* Add styling for the "password" link */
        .password {
            margin-top: 10px;
        }

        .password a {
            text-decoration: none;
            color: oklch(from color l c h);
        }

        /* Remove underline for the Facebook, Google, and Twitter links */
        .signup-text a {
            text-decoration: none;
            color: oklab(lightness a b);
            margin: 0 5px;
        }

        p a {
            text-align: center;
            text-decoration: none;
        }

        p {
            text-align: center;
        }
    </style>
</head>

<body>
    <form action="Signup">
        <h1>Sign Up</h1>
        <label for="name">Name</label>
        <input type="text" id="name" name="name" required>

        <label for="email">Email</label>
        <input type="email" id="email" name="email" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

      <%--   <label for="confirm-password">Confirm Password</label>
        <input type="password" id="confirm-password" name="confirm-password" required>
        --%>
        <input type="submit" value="Sign Up">
    </form>

    <div class="or-text">or sign up using</div>

    <div class="signup-text">
        <!-- Removed underline for the Facebook, Google, and Twitter links -->
        <a href="#"><i class="fab fa-facebook"></i></a>
        <a href="#"><i class="fab fa-google"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
    </div>
    <p>Already have an account? <a href="Login.jsp">Login here.</a></p>



</body>
</html>