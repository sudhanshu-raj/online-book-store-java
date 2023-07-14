package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginSignUp;

@WebServlet("/checkSignUpOTP")
public class checkSignUPOTP extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		String email = (String) session.getAttribute("email");
		String number = (String) session.getAttribute("number");
		String password = (String) session.getAttribute("password");
		int otp = (int) session.getAttribute("signUpOTP");
		String userOtp2 = request.getParameter("otp");

		int userOtp = 0;
		if (userOtp2 != null) {
			userOtp = Integer.parseInt(userOtp2);
		}

//	
		LoginSignUp obj = new LoginSignUp();

		try {

			if (userOtp == otp) {
				obj.isUserAdded(username,email,password,number);
				
				response.sendRedirect("booksCatalogue.jsp");
				//session.removeAttribute("signUpOTP");
			}

			else {
				session.setAttribute("invalidOTP", "Wrong otp ");
				response.sendRedirect("otpSignUp.jsp");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		

	}

}
//PrintWriter out=response.getWriter();
		// out.print(username+", "+email+", "+password+", "+number+", "+ "otp
		// :"+userOtp+" real otp "+otp);