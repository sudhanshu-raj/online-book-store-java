package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import conn.dbConn;
import model.Cart;
import model.Products;

public class ProductDAO {

	private Connection conn = null;
	private PreparedStatement preStat = null;
	private ResultSet rs = null;

	public List<Products> getAllbooks() {

		List<Products> booksList = new ArrayList<>();
		try {
			conn = dbConn.getConnection();
			Statement stat = conn.createStatement();
			rs = stat.executeQuery("select *from products");
			while (rs.next()) {

				Products book = new Products();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setQuantity(rs.getInt(3));
				book.setPrice(rs.getFloat(4));
				book.setCategory(rs.getString(5));
				book.setAuthor(rs.getString(6));
				book.setImageName(rs.getString(7));
				booksList.add(book);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			if (preStat != null) {
				try {
					preStat.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}

		return booksList;

	}


	public float getCartValue(List<Cart> cartList) {

		float totalValue = 0;

		try {
			conn = dbConn.getConnection();
			for (Cart c : cartList) {
				preStat = conn.prepareStatement("select price from products where id=?");
				preStat.setInt(1, c.getId());
				rs = preStat.executeQuery();
				while (rs.next()) {   //here while is not needed 

					totalValue = (rs.getFloat(1) + totalValue) * c.getcartQuantity();
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			if (preStat != null) {
				try {
					preStat.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
		return totalValue;

	}
	
	public List<Products> searchItem(String name){
		List<Products> list=new ArrayList<>();
		try {
			conn=dbConn.getConnection();
			preStat=conn.prepareStatement("select * from products where LOWER(name) LIKE LOWER(?)");
			preStat.setString(1, "%"+name+"%");
			rs=preStat.executeQuery();
			while(rs.next()) {
				Products book = new Products();
				book.setId(rs.getInt(1));
				book.setName(rs.getString(2));
				book.setQuantity(rs.getInt(3));
				book.setPrice(rs.getFloat(4));
				book.setCategory(rs.getString(5));
				book.setAuthor(rs.getString(6));
				book.setImageName(rs.getString(7));
				list.add(book);
			}
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

	public static void main(String[] args) {
		List<Products> list = new ArrayList<>();
		ProductDAO obj = new ProductDAO();
		list = obj.searchItem("geeta");

		for (Products prod : list) {
			System.out.println(prod.getId() + "," + prod.getName() + "," + prod.getAuthor() + "," + prod.getPrice()
					+ " ," + prod.getImageName());
		}
		System.out.println("Task completed");
	}

}
