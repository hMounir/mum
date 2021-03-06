<%--
  Created by IntelliJ IDEA.
  User: Hisham
  Date: 3/13/2019
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link type="text/css" rel="stylesheet" href="style.css"/>
</head>
<body>

<h2>Login Form</h2>

<form action="login" method="post" id="loginForm">
    <div class="imgcontainer">
        <img src="images/img_avatar2.png" alt="Avatar" class="avatar">
    </div>
    <div class="loginInfo">
        <p>Use Login credentials</p>
        <p>UserName: Hisham</p>
        <p>Password: 123</p>
    </div>

    <div class="container">
        <label for="uname"><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="uname" required id="uname"/>

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="psw" required id="psw"/>

        <button type="submit" id="submitBtn">Login</button>
        <label>
            <input type="checkbox" name="remember"> Remember me
        </label>
    </div>
</form>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="login.js" type="text/javascript"></script>
</body>
</html>
