<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@page import="DAO.CartDAO"%>
     <%@page import="model.Cart"%>
    <%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
 <meta name="viewport" content="width=device-width,initial-scale=1">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
	
  	<link rel="stylesheet" href="cart.css">
  <title>My Cart</title>

</head>
<body>


<%  response.setHeader("Cache-control", "no-cache,no-store,must-revalidated");
if(session.getAttribute("username")==null){
	  response.sendRedirect("index.jsp");
}
 %>
  <%@ include file="header.jsp" %>
  
  <h1>My Cart</h1>

  
   <%
   if(session.getAttribute("zeroCartValue")!=null){ %>
	   <h3 style='color:black; text-align: center'>${zeroCartValue } </h3>
	   
  <%  }
   session.removeAttribute("zeroCartValue");
   %>
  

  
  <div class="container">
    <div class="cart-items">
      <table>
        <tr>
          <th>Image</th>
          <th>Name</th>
          <th>Price</th>
          <th>Quantity</th>
          <th>Subtotal</th>
          <th>Remove</th>
        </tr>
        <!-- Replace the following rows with your actual cart items dynamically -->
      <%! float totalCartValue=0; %>
         <%
         CartDAO cartDao=new CartDAO();
         String username=(String)session.getAttribute("username");
         List<Cart> cartProducts=cartDao.getCartDetails(username);
       totalCartValue=cartDao.getTotalPrice();
       session.setAttribute("totalCartValue", totalCartValue);
        
        if(cartProducts!=null){
      
         
         for(Cart c:cartProducts){
        	   
   
  %>
        <tr>
          <td><img src="product_images/<%=c.getImageName() %>.jpg" alt="Product_image" width="50"></td>
          <td><%=c.getName()%></td>
          <td>Rs <%=c.getPrice() %></td>
          <td><form class="form-inline" >
						<input type="hidden" name="id" value="<%= c.getId()%>" class="form-input">
							<div class="form-group d-flex justify-content-between">
								<a class="btn bnt-sm btn-incre" href="increaseQuantity?id=<%=c.getId()%>&qty=<%=c.getcartQuantity() %>" style="border:none;position:relative;"><i class="fas fa-plus-square"></i></a> 
								<input type="text" name="quantity" class="form-control"  value=<%=c.getcartQuantity() %> readonly> 
								<a class="btn btn-sm btn-decre" href="decreaseQuantity?id=<%=c.getId()%>&qty=<%=c.getcartQuantity() %>" style="border:none;position:relative;"><i class="fas fa-minus-square"></i></a>
							</div>
						</form></td>
          <td class="subtotal">Rs <%=c.getPrice()*c.getcartQuantity() %></td>
          <td>
          <a href= "removeCart?id=<%=c.getId()%>">   <button class="remove-button" >Remove</button></a>
</td>
        </tr>
        
         <% } } %>
        <!-- End of cart items -->
     
        <tr>
          <td colspan="4"><strong>Total</strong></td>
          <td class="subtotal">Rs <%=totalCartValue %></td>
          <td></td>
        </tr>
       
      </table>
    </div>
    
    <div class="checkout">
      <h2>Checkout</h2>
      <p>Your total is: <strong>Rs <%=totalCartValue %></strong></p>
      <p>Click on Process order to enter shipping details:</p>
      <!-- Add your checkout form fields here -->

      <div class="checkout-buttons">
        <a href="booksCatalogue.jsp" class="button">Back to Shopping</a>
        <a href="shippingForm.jsp" class="button">Process order</a>
      </div>
      
    </div>
  </div>
</body>
</html>
