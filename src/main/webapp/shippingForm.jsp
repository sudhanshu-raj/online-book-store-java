<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="DAO.CartDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="shippingForm.css">
</head>
<body>
<%

response.setHeader("Cache-control", "no-cache,no-store,must-revalidated");
          if(session.getAttribute("username")==null){
        	  response.sendRedirect("index.jsp");
          }


%>

	<%
	
	float totalCartValue = (float)session.getAttribute("totalCartValue");
	if(totalCartValue==0){
		session.setAttribute("zeroCartValue", "Your cart is empty add something to process order");
		response.sendRedirect("cart.jsp");
	}
	else{
	session.removeAttribute("zeroCartValue");
	}
	%>

	<%@ include file="header.jsp"%>
	<div class="container">
		<h1>Shipping</h1>
		<p>Please enter your shipping details.</p>
		<hr />
		 <form action="addShipping">
		<div class="form">

           
			<div class="fields fields--2">
				<label class="field"> <span class="field__label"
					for="firstname">Full name</span> <input class="field__input"
					type="text" name="fullName"  />
				</label> <label class="field"> <span class="field__label"
					for="lastname">Contact Number</span> <input class="field__input"
					type="text" pattern="[0-9]{10}"  name="contactNumber"  />
				</label>
			</div>
			<label class="field"> <span class="field__label"
				for="address">Address</span> <input class="field__input" type="text"
				name="address" />
			</label> <label class="field"> <span class="field__label"
				for="country">Country</span> <select class="field__input"
				name="country">
					<option value="India">India</option>
					<option value="Unitedstates">United States</option>
					<option value="China">China</option>
					<option value="Japan">Japan</option>
					<option value="Russia">Russia</option>
			</select>
			</label>
			<div class="fields fields--3">
				<label class="field"> <span class="field__label"
					for="zipcode">Zip code</span> <input class="field__input"
					type="text" name="zipcode" />
				</label> <label class="field"> <span class="field__label" for="city">City</span>
					<input class="field__input" type="text" name="city" />
				</label> <label class="field"> <span class="field__label"
					for="state">State</span> <select class="field__input" name="state">
						<option value="Delhi">Delhi</option>
						<option value="Bihar">Bihar</option>
						<option value="UP">Uttar Pradesh</option>
						<option value="Nagaland">Nagaland</option>
				</select>
				</label>
			</div>
		</div>
		<hr>
		<button class="button" type="submit" >Continue</button><br> 
		</form>
		<a href="cart.jsp"><button class="button" >Back to Cart</button></a>
	</div>
</body>
</html>