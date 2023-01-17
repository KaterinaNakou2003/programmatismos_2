package com.CodeCom.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Likes {

	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
    String SQL_statement = null;
    Message message;

	public String likedUser(int y) {
		connectDB();
		String lkduser = null;
		y = y + 1002;
		SQL_statement = "SELECT sender FROM Messages WHERE message_id = "
				+ y;
		try {
			if (conn != null ) {
				st = conn.createStatement();
				rs = st.executeQuery(SQL_statement);
				if (rs.next()) {
					lkduser = rs.getString("sender");
				}
			
				st.close();
				rs.close();
			}
		}catch (SQLException e){
				System.out.println("SQL statement exception1" + e);
		}
		return lkduser;
	}



	public String messageBody(int y) {
		connectDB();
		String msgbody = null;
		y = y + 1002;
		SQL_statement = "SELECT message_body FROM Messages WHERE message_id = " + y + ";";
		try {
			if (conn != null ) {
				st = conn.createStatement();
				rs = st.executeQuery(SQL_statement);
				if (rs.next()) {
					msgbody = rs.getString("message_body");
				}
				st.close();
				rs.close();
				}
		}catch (SQLException e) {
				System.out.println("SQL statement exception2" + e);
		}
		return msgbody;
	}



	public int likeCounter(int y) {
		connectDB();
		int d = -1;
		y = y + 1002;
    	SQL_statement =" SELECT COUNT(Likes.message_id) as countoflikes FROM Likes, Messages WHERE Messages.message_id=Likes.message_id"
    			+ " AND Likes.message_id=" + y + ";";
    	try {
			if (conn != null ) {
				st = conn.createStatement();
				rs = st.executeQuery(SQL_statement);
				if (rs.next()) {
					d = rs.getInt("countoflikes");
				}
				st.close();
				rs.close();
	        }
		}catch (SQLException e) {
			System.out.println("SQL statement exception3" + e);
		}
		return d;
	}



	public String updateLikes(String username, String likedname, int y) {
		String message = " ";
		connectDB();
		y = y + 1002;
		int count = 0;
		SQL_statement = "SELECT message_id, liker FROM Likes WHERE message_id = "
			 + y + " AND liker = '" + username + "';";
		try {
			Statement st1 = conn.createStatement();
			ResultSet rs1 = st1.executeQuery(SQL_statement);
			boolean x = rs1.next();
			while (x == true) {
				count++;
				x = rs1.next();
			}
			if (count == 0) {
				SQL_statement = "SELECT typeofmessage FROM Messages WHERE "
						+ "message_id = " + y + ";";
				try {
					Statement st2 = conn.createStatement();
					ResultSet rs2 = st2.executeQuery(SQL_statement);
					if (rs2.next()) {
						if (rs2.getInt("typeofmessage") != -1) {
							message = "successful";
							SQL_statement = "INSERT INTO Likes(message_id,liked_user,liker) VALUES(" + y + ",'" + likedname + "','" + username + "');";
							try {
								if (conn != null ) {
									st = conn.createStatement();
									st.executeUpdate(SQL_statement);
									st.close();
								}
							} catch (SQLException e) {
								System.out.println("SQL statement exception4,5" + e);
							}
						} else {
							message = "likemessage";
						}
					}
					st2.close();
					rs2.close();
				} catch (SQLException e) {
					System.out.println("SQL statement exception4,5" + e);
				}
			}
		} catch (SQLException e) {
			System.out.println("SQL statement exception4" + e);
		}
		return message;
	}
	
	public void connectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
					+ "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");
		} catch (Exception e) {
					System.err.println("Connection failed");
		}
	}
}
