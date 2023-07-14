package DAO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;

import conn.dbConn;

public class LoginSignUp {
	public static void main(String[] args) {

		LoginSignUp obj = new LoginSignUp();
		String ans=obj.isUserFound("ewew");
		System.out.println(ans);
		if(ans==null) {
			System.out.println("Not available");
		}
	}

	private Connection conn = null;
	private PreparedStatement preStat = null;
	private ResultSet rs = null;

	public boolean isUserAdded(String uname, String email, String pass, String phone) throws SQLException {

		try {
			conn = dbConn.getConnection();
			preStat = conn.prepareStatement(
					"insert into user_credentials (username,email,password,phone_number) values(?,?,?,?)");
			preStat.setString(1, uname);
			preStat.setString(2, email);
			preStat.setString(3, pass);
			preStat.setString(4, phone);
			int result = preStat.executeUpdate();

			if (result == 1) {
				return true;
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean isUserNameAvailable(String username) {
		try {
			conn = dbConn.getConnection();
			preStat = conn.prepareStatement("select * from user_credentials where username=?");
			preStat.setString(1, username);
			rs = preStat.executeQuery();
			if (rs.next()) {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
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

	public boolean isNumberAvailable(String number) {
		try {
			conn = dbConn.getConnection();
			preStat = conn.prepareStatement("select * from user_credentials where phone_number=?");
			preStat.setString(1, number);
			rs = preStat.executeQuery();
			if (rs.next()) {
				return false;
			}

		} catch (ClassNotFoundException | SQLException e) {
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

	public boolean isUserValid(String uname, String pass) throws SQLException {

		try {
			conn = dbConn.getConnection();
			preStat = conn.prepareStatement("select *from user_credentials where username=? and password =?");
			preStat.setString(1, uname);
			preStat.setString(2, pass);

			rs = preStat.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (ClassNotFoundException e) {
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

	public String isUserFound(String data) {
		String number = null;
		try {
			conn = dbConn.getConnection();
			preStat = conn.prepareStatement(
					"select phone_number from user_credentials where username=? or email=? or phone_number=?");
			preStat.setString(1, data);
			preStat.setString(2, data);
			preStat.setString(3, data);
			rs = preStat.executeQuery();

			if (rs.next()) {
				number = rs.getString(1);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
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

		return number;
	}

	public void changePassword(String number,String password) {
		try {
			conn=dbConn.getConnection();
			preStat=conn.prepareStatement("update user_credentials set password=? where phone_number=?");
			preStat.setString(1, password);
			preStat.setString(2, number);
			preStat.executeUpdate();
			
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(preStat!=null) {
				try {
					preStat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	public int generateOtp() {
		Random random = new Random();
		return random.nextInt(9000) + 1000;
	}

	public void sendOTP(int message, String number) {
		try {
			String apiKey = "3XQMUNgTW7P6x19hlkYFic2ypsGOjVS0nHzIdEDJCbtawK8qvBsbTkC9aQZ3tIof5w6qiEuGDY2m4NdA";
			String sendId = "FSTSMS";

//	            message= URLEncoder.encode("UTF-8");
			number = URLEncoder.encode(number, "UTF-8");
			String language = "english";
			String route = "p";

			String myUrl = "https://www.fast2sms.com/dev/bulk?authorization=" + apiKey + "&sender_id=" + sendId
					+ "&message=" + message + "&language=" + language + "&route=" + route + "&numbers=" + number;
			URL url = new URL(myUrl);

			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("cache-control", "no-cache");

			int code = con.getResponseCode();
			System.out.println("Response code : " + code);

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			String response;
			while ((response = br.readLine()) != null) {
				System.out.println(response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
