package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import model.Cart;

@WebServlet("/decreaseQuantity")
public class DecreaseCartQuantity extends HttpServlet
{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

		HttpSession session = req.getSession();
		int pId = Integer.parseInt(req.getParameter("id"));
		int quantity = Integer.parseInt(req.getParameter("qty"));
		String username = (String) session.getAttribute("username");
		CartDAO cartDAO = new CartDAO();
		if(quantity>1) {
	
		cartDAO.decreaseCart(pId, username);
		res.sendRedirect("cart.jsp");
		}
		else {
			cartDAO.removeItem(pId, username);
			res.sendRedirect("cart.jsp");
		}


	}

}
