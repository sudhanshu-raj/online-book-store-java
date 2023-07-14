<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forget Password</title>
 <link rel="stylesheet" href="forgetPassword.css">
</head>
<body>

  <div class="container">
       
        <h2 class="heading">Forget Password</h2>
               <h4 class="description">Enter your username/email/phone number</h4>
               <% if(session.getAttribute("userNotFound")!=null){ %>
               <h5 style="color: red;">${userNotFound}</h5>
               <%} session.removeAttribute("userNotFound"); %>
               <form action="forgetPassword">
                   <input type="text" class="input" name="data" placeholder="Username/email/number" required>
                   <button type="submit">Submit</button>
               </form>
                <a href="index.jsp" class="link">Back</a>
           </div>
</body>
</html>