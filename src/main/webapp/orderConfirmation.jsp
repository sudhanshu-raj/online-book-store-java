 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Order Confirmed</title>
  <link rel="stylesheet" href="orderConfirmation.css">
</head>
<body>
<%@ include file="header.jsp"%>
  <div class="container">
    <div class="order-summary">
      <h1>Order Confirmed</h1>
      <h2>Thanks for shopping with us</h2>
      <img src="product_images/booking.png" alt="Product Image" class="product-image">
<!--       <h2>Your Order</h2>
      <p>Product: XYZ</p>
      <p>Price: $19.99</p>
      <p>Quantity: 1</p> -->
      <p>Order Value : Rs <%=(float)session.getAttribute("totalCartValue") %></p>
      <p>Your order will reach to you in  1 week.</p>
      <p>Payment Mode:<%=session.getAttribute("payment_mode") %></p>
     <a href="booksCatalogue.jsp"> <button class="button">Back to home</button></a>
    </div>
  </div>
</body>
</html>
