<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="DAO.ProductDAO"%>
<%@page import="model.Products"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Items</title>
<link rel="stylesheet" href="booksCatalogue.css">
</head>
<body>

<%
	response.setHeader("Cache-control", "no-cache,no-store,must-revalidated");
	if (session.getAttribute("username") == null) {
		response.sendRedirect("index.jsp");
	}
	%>
	<%@ include file="header.jsp"%>


	<div class="content">
		<h1>Results of your search</h1>
		<%
		if (session.getAttribute("productAdded") != null) {
		%>
		<h3 style='color: black; text-align: center'>${productAdded }</h3>

		<%
		}
		session.removeAttribute("productAdded");
		if (session.getAttribute("alreadyAdded") != null) {
		%>
		<h3 style='color: black; text-align: center'>${alreadyAdded}</h3>
		<%
		}
		session.removeAttribute("alreadyAdded");
		%>
		<div class="product-container">

			<%
			ProductDAO pod = new ProductDAO();
			String name=request.getParameter("data");
			List<Products> bookList = pod.searchItem(name);

			for (Products product : bookList) {
			%>
			<div class="product-card">
				<img src="product_images/<%=product.getImageName()%>.jpg"
					alt="Product 1" class="product-image">
				<div class="product-details">
					<h2 class="product-title"><%=product.getName()%></h2>
					<p class="product-price"><%=product.getPrice()%></p>
					<p class="product-description"><%=product.getCategory()%></p>
				</div>
				<form action="add-to-cart">
					<input type="number" name="quantity" value=1 hidden> <input
						type="number" name="pID" value=<%=product.getId()%> hidden>
					<button class="add-to-cart-button ">Add to Cart</button>
				</form>

			</div>

			<%
			}
			%>

		</div>
	</div>

</body>
</html>