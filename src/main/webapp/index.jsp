<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login</title>
<link rel="stylesheet" href="login_style.css">
</head>
<body>
	<div class="nav">
		<div class="logo">
			<img src="logo_free.png" alt="logo">
		</div>
	</div>
	<div class="content">
		<div class="container">
			<h2>Login</h2>
			<% 
      if(session.getAttribute("invalidLogin")!=null){ %>
    	  <h4>Login failed ! Please try again.  </h4> 
      <%} session.removeAttribute("invalidLogin");
 
%>
			<form action="login">
				<input type="text" class="input" name="userName"
					placeholder="Username" required> <input type="password"
					class="input" name="pswd" placeholder="Password" required>
				<button type="submit">Submit</button>
			</form>
			<p>
				Don't have an account? <a href="signUp.jsp" class="link">Sign up</a>
			</p>
			<a href="forgetPassword.jsp" class="link">Forgot Password </a>
		</div>
	</div>
</body>
</html>