package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conn.dbConn;
import model.Cart;

public class CartDAO {
	
	public float totalPrice;

	private Connection conn = null;
	private PreparedStatement preStat = null;
	private ResultSet rs = null;

	public boolean addToCart(Cart c) {

		try {
			conn = dbConn.getConnection();
			preStat = conn.prepareStatement("insert into user_cart(username,product_id,cart_quantity) values(?,?,?)");
			preStat.setString(1, c.getusername());
			preStat.setInt(2, c.getId());
			preStat.setInt(3, c.getcartQuantity());
			int result = preStat.executeUpdate();
			if (result != 1) {
				return false;
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

		return true;
	}

	public boolean isProductAdded(int pID, String username) throws ClassNotFoundException {

		try {
			conn = dbConn.getConnection();
			preStat = conn.prepareStatement("SELECT * FROM user_cart WHERE product_id = ? and username=? ");
			preStat.setInt(1, pID);
			preStat.setString(2, username);
			rs = preStat.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}

		} catch (SQLException e) {
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
		return false;

	}

	public List<Cart> getCartDetails(String username) {

		List<Cart> cartList = new ArrayList<>();

		try {
			conn = dbConn.getConnection();
			String query = "select p.id,p.name,p.price,p.category,p.author,p.image,c.cart_quantity "
					+ "from products p " + "inner join user_cart c " + "on p.id=c.product_id " + "where username=?";

			preStat = conn.prepareStatement(query);
			preStat.setString(1, username);

			rs = preStat.executeQuery();
			while (rs.next()) {
				Cart c = new Cart();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setPrice(rs.getFloat(3));
				c.setCategory(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setImageName(rs.getString(6));
				c.setcartQuantity(rs.getInt(7));
				totalPrice=(rs.getFloat(3)*rs.getInt(7)+totalPrice);
				cartList.add(c);

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

		return cartList;
	}

	public void increaseCart(int pID, String username) {

		try {
			conn = dbConn.getConnection();

			String query = "update user_cart set cart_quantity=(select cart_quantity from user_cart where username=? and product_id=?)+1 "
					+ "where username=? and product_id=?";
			preStat = conn.prepareStatement(query);
			preStat.setString(1, username);
			preStat.setInt(2, pID);
			preStat.setString(3, username);
			preStat.setInt(4, pID);
			rs = preStat.executeQuery();
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

	}

	public void decreaseCart(int pID, String username) {

		try {
			conn = dbConn.getConnection();

			String query = "update user_cart set cart_quantity=(select cart_quantity from user_cart where username=? and product_id=?)-1 "
					+ "where username=? and product_id=?";
			preStat = conn.prepareStatement(query);
			preStat.setString(1, username);
			preStat.setInt(2, pID);
			preStat.setString(3, username);
			preStat.setInt(4, pID);
			rs = preStat.executeQuery();
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

	}
	
	public void removeItem(int pID, String username) {

		try {
			conn = dbConn.getConnection();

			String query = "delete user_cart where username=? and product_id=?";
			preStat = conn.prepareStatement(query);
			preStat.setString(1, username);
			preStat.setInt(2, pID);
			rs = preStat.executeQuery();
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

	}
	
	public float getTotalPrice() {
		return totalPrice;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		CartDAO obj = new CartDAO();

//		List<Cart> CartList=obj.getCartDetails("kirrish");
//		for(Cart c: CartList) {
//			System.out.println("Id="+c.getId()+" name="+c.getName()+
//					" price="+c.getPrice()+" category="+c.getCategory()+" author="+
//					c.getAuthor()+" image="+c.getImageName()+" quantity="+c.getcartQuantity());

		obj.removeItem(21, "rahul");
	}

}
