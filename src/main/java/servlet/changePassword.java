package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginSignUp;

@WebServlet("/changePassword")
public class changePassword extends HttpServlet{
	 
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		int userOtp=Integer.parseInt(request.getParameter("otp"));
		String password=request.getParameter("password");
		
		HttpSession session=request.getSession();
		int correctOtp=(int) session.getAttribute("passwordOtp");
		String number=(String)session.getAttribute("number");
		
		LoginSignUp obj= new LoginSignUp();
		if(userOtp==correctOtp) {
			obj.changePassword(number, password);
			response.sendRedirect("index.jsp");
		}
		else {
			session.setAttribute("inValidPassOTP", "Invalid OTP");
			response.sendRedirect("changePassword.jsp");
		}
	}

}
