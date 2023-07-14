<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
 <link rel="stylesheet" type="text/css" href="login_style.css">
</head>
<body>

<div class="nav">
		<div class="logo">
			<img src="logo_free.png" alt="logo">
		</div>
	</div>
	<div class="content">
 <div class="container">
  <% 
      if(session.getAttribute("signUpFail")!=null){ %>
    	  <h5>${signUpFail}  </h5> 
      <%} session.removeAttribute("signUpFail");
 
%>
        <h2>Sign Up</h2>
        <form action=signUP>
            <input type="text" class="input" name="userName" placeholder="Username" required>
            <input type="email" class="input" name="email" placeholder="Email" required>
            <input type="text" class="input" pattern="[0-9]{10}" name="number" placeholder="Phone Number" required>
            <input type="password"  class="input" name= "password" placeholder="Password" required>
            <button type="submit">Submit</button>
        </form>
        <p>Already have an account? <a href="index.jsp">Login</a></p>
    </div>
    </div>
</body>
</html>