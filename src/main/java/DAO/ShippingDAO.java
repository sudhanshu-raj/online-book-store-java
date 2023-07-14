package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conn.dbConn;
import model.Shipping;


public class ShippingDAO {

	private Connection conn = null;
	private PreparedStatement preStat = null;
	private ResultSet rs = null;
 
	public void addShippingDetails(Shipping sp) {
		
		try {
			conn=dbConn.getConnection();
			preStat=conn.prepareStatement("insert into shipping (fullname,contactNumber,address,country,zipcode,city,c_state) values(?,?,?,?,?,?,?)");
			preStat.setString(1, sp.getFullName());
			preStat.setString(2, sp.getContactNumber());
			preStat.setString(3, sp.getAdress());
			preStat.setString(4, sp.getCountry());
			preStat.setString(5, sp.getPincode());
			preStat.setString(6, sp.getCity());
			preStat.setString(7, sp.getState());
			preStat.executeUpdate();
			
		}
		catch(ClassNotFoundException | SQLException e){
		    e.printStackTrace();
		}
	}
	
	
	
}
