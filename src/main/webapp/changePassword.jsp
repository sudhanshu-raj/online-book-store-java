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
               <h4 class="description">Enter your new password</h4>
               <% if(session.getAttribute("inValidPassOTP")!=null){ %>
               <h5 style="color: red;">${inValidPassOTP}</h5>
               <%} session.removeAttribute("inValidPassOTP"); %>
               <form action="changePassword">
                   <input type="text" class="input"  value=<%=session.getAttribute("number") %> readonly>
                     <input type="text" class="input" pattern="[0-9]{4}" name="otp" placeholder="OTP" required>
                   <input type="password" class="input" name="password" placeholder="New password" required>
                   <button type="submit">Submit</button>
               </form>
               <a href="forgetPassword.jsp" class="link">Back</a>
           </div>
</body>
</html>