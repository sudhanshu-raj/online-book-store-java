<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css" integrity="sha384-b6lVK+yci+bfDmaY1u0zE8YYJt0TZxLEAFyYSLHId4xoVvsrQu3INevFKo+Xir8e" crossorigin="anonymous">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
  <link rel="stylesheet" href="header.css">
</head>
<body>


 <div class="topnav">
        <div class="left">
            <div class="logo">
                <img src="logo_free.png" alt="">
            </div>
            
            <div class="searchBar">
                <form action="searchItems.jsp">
                    <input type="text" name="data" pattern="^[a-zA-Z0-9 ]{2,40}$" placeholder="Type here to search..." required>
                    <button class="btn"><i class="bi bi-search"></i></button>
                </form>
            </div>
        </div>

        <div class="right">
            <a href="booksCatalogue.jsp">Home</a>
            <a href="cart.jsp">Cart</a>
            <a href="logout">Logout</a>
            <a href="#" class="profile">
                <i class="bi bi-person-fill"></i>
               <%=session.getAttribute("username") %>
            </a>



        </div>
    </div>



</body>
</html>
