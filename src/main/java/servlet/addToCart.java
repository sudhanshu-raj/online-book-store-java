package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.CartDAO;
import model.Cart;

@WebServlet("/add-to-cart")
public class addToCart extends HttpServlet {
	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		Cart cart=new Cart();
		
		HttpSession session=req.getSession();
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		int id=Integer.parseInt(req.getParameter("pID"));
		String username=(String) session.getAttribute("username");
		cart.setusername(username);
		cart.setId(id);
		cart.setcartQuantity(quantity);

		
		
		CartDAO cartDao=new CartDAO();
		try {
			if(!cartDao.isProductAdded(id, username)) {
			    if(cartDao.addToCart(cart)) {
			    	session.setAttribute("productAdded","Producted added into your cart");
			    	res.sendRedirect("booksCatalogue.jsp");
			    	
			    }
				
				
			}
			else {
				session.setAttribute("alreadyAdded", "Already added, please check your cart");
		    	res.sendRedirect("booksCatalogue.jsp");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
				
//		List<Cart> cartList=new ArrayList<>();
//	
//	
//		 List<Cart> cartList2=(List<Cart>) session.getAttribute("cartList");
//		
//		if(cartList2!=null) {
//			cartList = cartList2;
//		    boolean alreadyAdded = false;
//
//		    for (Cart c : cartList) {
//		        if (c.getId() == id) {
//		            alreadyAdded = true;
//		            break;
//		        }
//		    }
//
//		    if (alreadyAdded) {
//		        res.sendRedirect("booksCatalogue.jsp");
//		        session.setAttribute("alreadyAdded", "Product already added into cart");
//		    } else {
//		        cartList.add(cart);
//		        session.setAttribute("cartList", cartList);
//		        session.setAttribute("productAdded", "Product added into cart");
//		        res.sendRedirect("booksCatalogue.jsp");
//		    }
//		}
//
//		else {
//			cartList.add(cart);
//			session.setAttribute("cartList", cartList);
//			session.setAttribute("productAdded", "Product added into cart");
//			res.sendRedirect("booksCatalogue.jsp");
//		}
		
		
		
		
        
        
		
		
	}

}
