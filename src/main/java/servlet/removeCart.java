package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import model.Cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
@WebServlet("/removeCart")
public class removeCart extends HttpServlet {
	
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession session = req.getSession();
		int pId = Integer.parseInt(req.getParameter("id"));
		String username = (String) session.getAttribute("username");

		CartDAO cartDAO = new CartDAO();
		cartDAO.removeItem(pId, username);
		res.sendRedirect("cart.jsp");
		
	}

}
