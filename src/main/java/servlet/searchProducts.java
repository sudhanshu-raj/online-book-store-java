package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;


@WebServlet("/searchItem")
public class searchProducts extends HttpServlet {
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) {
		
		String name=request.getParameter("data");
		
		ProductDAO obj= new ProductDAO();
		
	}

}
