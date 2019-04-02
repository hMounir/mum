<%--
  Created by IntelliJ IDEA.
  User: Hisham
  Date: 3/14/2019
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
    <title>Products list</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <link rel="stylesheet" href="assets/css/proctucts.css"/>
    <script src="assets/js/cart.js"></script>
</head>
<body class="bodyclass">

<h1> Products List</h1>


<div class="row">
    <div class="firstColumn">
        <div class="row">
        </div>
    </div>
    <div class="secondColumn">
        <h1>Cart List</h1>
        <form action="products?requestType=checkout" method="post">
            <input type="hidden" id="totalCost" name="totalCost"/>
            <div>
            <ul id="show-cart">
            </ul>
            <div > Total Cart:$ <span id="total-cart"> </span></div>
            <div> You have <span id="count-cart"> X </span> itmes in your cart</div>
        </div>
        <div id="buttonsList">
            <button id="checkout">Checkout</button>
            <button id="clear-cart">clear cart</button>
        </div>
        </form>
    </div>
</div>
</body>
</html>
