package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import model.Cart;
import model.Orders;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import DAO.OrderDAO;

@WebServlet("/confirmOrder")
public class confirmOrder extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		CartDAO cartDao=new CartDAO();
		
		String payment_mode=req.getParameter("payment-option");
		
		HttpSession session=req.getSession();
		session.setAttribute("payment_mode", payment_mode);
		String username=(String)session.getAttribute("username");
		List<Cart > listCart=cartDao.getCartDetails(username);
		
		OrderDAO od=new OrderDAO();
		CartDAO cart=new CartDAO();
		PrintWriter out=res.getWriter();
		
		if(listCart!=null) {
			
			for(Cart c:listCart) {
				Orders order=new Orders();
				order.setUsername(username);
				order.setProduct_id(c.getId());
				order.setQuantity(c.getcartQuantity());
				order.setPrice(c.getPrice());
				order.setpayment_mode(payment_mode);

				
				cart.removeItem(c.getId(), username);
				
				
			}
		}
         res.sendRedirect("orderConfirmation.jsp");
		
		
	}

}
