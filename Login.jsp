<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Login from</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">

</head>
<body>
<style>
    /* Add some basic styling for the form */
    body {
          background-image: url("image.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
            filter:brightness(90%);
        }
    form {
      width: 300px;
      margin: 0 auto;
      padding: 20px;
      border: 1px solid #ccc;
      box-shadow: 0px 0px 10px 1px rgba(0, 0, 0, 0.1);
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
      color: orangered;
    }

    /* Remove underline for the Facebook, Google, and Twitter links */
    .signup-text a {
      text-decoration: none;
      color: rgb(rgb(110, 11, 11), rgb(7, 75, 7), rgb(9, 9, 85));
      margin: 0 5px;
    }
  </style>
</head>
<body>
  <form action="Login" method="get">
    <h1>Login</h1>
    <label for="email">Email</label>
    <input type="email" id="email" name="email" required>

    <label for="password">Password</label>
    <input type="password" id="password" name="password" required>
    
    <!-- Password link with additional styling -->
    <div class="password">
      <a href="forgot.jsp">Forgot password?</a>
    </div>
    
    <input type="submit" value="Login">
  </form>

  <div class="or-text">or sign up using</div>

  <div class="signup-text">
    
    <a href="#"><i class="fab fa-facebook"></i></a>
    <a href="#"><i class="fab fa-google"></i></a>
    <a href="#"><i class="fab fa-twitter"></i></a>
  </div>
</body>
</html>