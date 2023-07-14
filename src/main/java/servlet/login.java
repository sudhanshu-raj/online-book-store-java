package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.websocket.Session;

import DAO.LoginSignUp;

@WebServlet("/login")
public class login extends HttpServlet{
	
	

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
		
		String username=req.getParameter("userName");
		String password=req.getParameter("pswd");
		
		HttpSession session=req.getSession();
		
		LoginSignUp obj=new LoginSignUp();
	try {
		
		if(obj.isUserValid(username,password)) {
			
			
			session.setAttribute("username", username);
			res.sendRedirect("booksCatalogue.jsp");
		}
		else {
			session.setAttribute("invalidLogin", "Login credentials are wrong,try again.");			
			res.sendRedirect("index.jsp");
		}
	}
	catch(IOException  | SQLException e) {
		e.printStackTrace();
	}
		
	}
}
