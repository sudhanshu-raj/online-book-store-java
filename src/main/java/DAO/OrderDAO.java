package DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import conn.dbConn;
import model.Orders;
import model.Products;
public class OrderDAO {
	
	Connection conn=null;
	PreparedStatement preStat=null;
	ResultSet rs=null;
			
	
	public int addOrders(Orders order) {
		
		int order_id=-1;
		try {
			conn=dbConn.getConnection();
			CallableStatement calStat=conn.prepareCall("{ call  insert_ordersP(?,?,?,?,?,?) }");
			calStat.setString(1,order.getUsername());
			calStat.setInt(2, order.getProduct_id());
			calStat.setInt(3, order.getQuantity());
			calStat.setDouble(4, order.getPrice());
			calStat.setString(5,order.getpayment_mode());
			calStat.registerOutParameter(6, Types.NUMERIC);
			
			calStat.executeUpdate();
			order_id=calStat.getInt(6);
		}
		catch(SQLException | ClassNotFoundException E) {
			E.printStackTrace();
		}
		finally {
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
		return order_id;
		
	}

	
}
