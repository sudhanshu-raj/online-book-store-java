<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="otpSignUp.css">
</head>
<body>

  <div class="container">

        <p class="heading">Enter your OTP </p>
        <p class="desc">OTP has been send to your number</p>
        <!-- <p class="error">Wrong OTP</p> -->
        <% if(session.getAttribute("invalidOTP")!=null){ %>
        <p class="error">${invalidOTP}</p>
        <% } session.removeAttribute("invalidOTP"); %>
        <form action="checkSignUpOTP"   >
            <input type="text" pattern="[0-9]{4}" name="otp" placeholder="OTP" required>
            <button type="submit">Submit</button>
          
        </form>
        <a href="signUp.jsp" class="back"> Back</a>
       
    </div>

</body>
</html>