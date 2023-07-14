package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.LoginSignUp;


@WebServlet("/signUP")
public class signUp extends HttpServlet {


	
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException {
		
		
		String username=req.getParameter("userName");
		String email=req.getParameter("email");
		String number =req.getParameter("number");
		String password =req.getParameter("password");
		
		LoginSignUp obj=new LoginSignUp();
		
		HttpSession session=req.getSession();
		try {
		if(obj.isUserNameAvailable(username)) {
			if(obj.isNumberAvailable(number)) {
//				req.setAttribute("username", username);
//				req.setAttribute("email", email);
//				req.setAttribute("number", number);
//				req.setAttribute("password", password);
//				RequestDispatcher dispatcher = req.getRequestDispatcher("/checkSignUpOTP");
//				dispatcher.forward(req, res);
				int otp=obj.generateOtp();
				obj.sendOTP(otp, number);
				//obj.isUserAdded(username,email,password,number);
				session.setAttribute("signUpOTP",otp);
				session.setAttribute("username",username);
				session.setAttribute("email",email);
				session.setAttribute("number",number);
				session.setAttribute("password",password);
				
				res.sendRedirect("otpSignUp.jsp");
			}
			else {
			session.setAttribute("signUpFail", "Phone number already exists ");
			res.sendRedirect("signUp.jsp");
			}
//			res.sendRedirect("welcome.jsp");
		}
		else {
			session.setAttribute("signUpFail", "UserName already exists, try with different username");
			res.sendRedirect("signUp.jsp");
			
			
		}
		
		}
		catch(IOException e) {
			e.printStackTrace();
		} 
		
		
		
		
	}
}
