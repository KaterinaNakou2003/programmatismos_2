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
		y =+ 1002;
		SQL_statement = "SELECT sender FROM Messages WHERE message_id = " + y + ";";
		try {
			if (conn != null ) {
				st = conn.createStatement();
				rs = st.executeQuery(SQL_statement);
				lkduser = rs.getString("sender");
				st.close();
				rs.close();
			}
		}catch (SQLException e){
				System.out.println("SQL statement exception" + e);
		}
			return lkduser;
	}



	public String messageBody(int y) {
		connectDB();
		String msgbody = null;
		y =+ 1002;
		SQL_statement = "SELECT message_body, FROM Messages WHERE message_id = " + y + ";";
		try {
			if (conn != null ) {
				st = conn.createStatement();
				rs = st.executeQuery(SQL_statement);
				msgbody = rs.getString("message_body");
				st.close();
				rs.close();
				}
		}catch (SQLException e) {
				System.out.println("SQL statement exception" + e);
		}
		return msgbody;
	}



	public int likeCounter(int y) {
		connectDB();
		int d = -1;
    	SQL_statement =" SELECT COUNT(*) FROM Likes WHERE message_id=" + y + ";";
    	try {
			if (conn != null ) {
				st = conn.createStatement();
				rs = st.executeQuery(SQL_statement);
				d = rs.getInt("COUNT");
				st.close();
				rs.close();
	        }
		}catch (SQLException e) {
			System.out.println("SQL statement exception" + e);
		}
		return d;
	}



	public void updateLikes(String username, String likedname, int y) {
		connectDB();
		SQL_statement = "INSERT INTO Likes(message_id,liked_user,liker) VALUES('" + y + "','" + likedname + "','" + username + "');";
		try {
			if (conn != null ) {
				st = conn.createStatement();
				st.executeUpdate(SQL_statement);
				String answer = messageBody(y);
				message.updateMessages(username,answer,-1);
				st.close();
			}
		} catch (SQLException e) {
			System.out.println("SQL statement exception" + e);
		}
	}


	public void connectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(
					"jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
					+ "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");
		} catch (Exception e) {
					System.err.println("Connection failed");
		}
	}


}
