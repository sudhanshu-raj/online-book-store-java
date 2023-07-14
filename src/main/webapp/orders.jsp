<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@page import="DAO.CartDAO"%>
     <%@page import="model.Cart"%>
    <%@page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<link rel="stylesheet" href="order.css">
<title>Confrim Order</title>
</head>
<body>
<%

response.setHeader("Cache-control", "no-cache,no-store,must-revalidated");
          if(session.getAttribute("username")==null){
        	  response.sendRedirect("index.jsp");
          }


%>
  <%-- <%@ include file="header.jsp" %> --%>
<div id="wrapper">
	<div id="container">
		<div id="left-col">
			<div id="left-col-cont">
				<h2>Summary</h2>
				
				<%! float totalPrice=0; %>
				
				<%
				
				CartDAO cartDao=new CartDAO();
				String username=(String)session.getAttribute("username");
				List<Cart> listCart=cartDao.getCartDetails(username);
				totalPrice=cartDao.getTotalPrice();
				if(listCart!=null){
					
					
					for(Cart c:listCart){
						
				
				%>
				
				<div class="item">
					<div class="img-col">
						<img src="product_images/<%=c.getImageName() %>.jpg" />
					</div>
					<div class="meta-col">
						<h3><%=c.getName() %></h3>
						<p class="price"><%= c.getPrice() %>(<%=c.getcartQuantity() %>)</p>
					</div>
				</div>
				 <%
					}
				}
				
				 %>
				
				<br>
				<p id="total">Total</p>
				<h4 id="total-price"><span>Rs </span><%=totalPrice %></h4>
			</div>
		</div>
		<div id="right-col">
			<h2>Payment options</h2>
			<div id="logotype">
				<img id="mastercard" src="http://emilcarlsson.se/assets/MasterCard_Logo.png" alt="" />
			</div>
			
			<form action="confirmOrder" method="post">
				
				  <input type="radio" id="cod" name="payment-option" value="cod">
      <label for="cod">Cash on Delivery &nbsp &nbsp<i class="bi bi-cash-stack"></i></label><br>
    
      <input type="radio" id="credit-card" name="payment-option" value="credit-card">
      <label for="credit-card">Credit Card &nbsp &nbsp <i class="bi bi-credit-card"></i></label><br>
    
      <input type="radio" id="upi" name="payment-option" value="upi">
      <label for="upi">UPI &nbsp &nbsp <i class="bi bi-wallet2"></i> </label><br>
				

			
				<a href="confirmOrder"><button id="purchase">Purchase</button></a>
				<p id="support"><a href="shippingForm.jsp">Back</a>.</p>
			</form>
		
		</div>
	</div>
</div>
<!-- <h1 id="dailyui">002</h1> -->
</body>
</html>