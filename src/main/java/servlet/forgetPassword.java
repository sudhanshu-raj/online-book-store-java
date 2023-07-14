package servlet;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginSignUp;

@WebServlet("/forgetPassword")
public class forgetPassword extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String userData=request.getParameter("data");
		
		LoginSignUp obj=new LoginSignUp();
		String number=obj.isUserFound(userData);
		HttpSession session=request.getSession();
		if(number!=null) {
			
			int otp=obj.generateOtp();
			obj.sendOTP(otp, number);
			session.setAttribute("passwordOtp", otp);
			session.setAttribute("number",number );
			
			response.sendRedirect("changePassword.jsp");
			
		}
		else {
			session.setAttribute("userNotFound", "Data not found, try again");
			response.sendRedirect("forgetPassword.jsp");
		}
	}

}
