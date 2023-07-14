package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.ShippingDAO;
import model.Shipping;

@WebServlet("/addShipping")
public class addShipping extends HttpServlet {
	
	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		
		String fullname=req.getParameter("fullName");
		String contact=req.getParameter("contactNumber");
		String address=req.getParameter("address");
		String country=req.getParameter("country");
		String zipcode=req.getParameter("zipcode");
		String city=req.getParameter("city");
		String state=req.getParameter("state");
		
		HttpSession session=req.getSession();
		ShippingDAO obj=new ShippingDAO();
		PrintWriter out=resp.getWriter();
		if((fullname.equals("")) || (contact.equals("")) || (address.equals("")) || (country.equals("")) || (zipcode.equals("")) || (city.equals("")) || (state.equals(""))) {
	
			session.setAttribute("shippingError","Please fill  correct data in all fields");
			resp.sendRedirect("shippingForm.jsp");

		}
		else {
			Shipping shipping=new Shipping(fullname, contact, address, country, zipcode, city, state);
		obj.addShippingDetails(shipping);
		resp.sendRedirect("orders.jsp");
			
		}
		
		
	}

}
