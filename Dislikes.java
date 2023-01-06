import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dislikes {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
	    String SQL_statement = null;
	
		public String dislikedUser(int y){
			connectDB();
			SQL_statement = "SELECT sender FROM Messages WHERE message_id = "+y+";";
			try {
				if (conn != null ) {
					st = conn.createStatement();
					rs = st.executeQuery(SQL_statement);
					String dislkduser = rs.getString("sender");
					st.close();
					rs.close();
					conn.close();
					return dislkduser;
				}
			}catch (SQLException e){
					System.out.println("SQL statement exception" + e);
			}
		}
	
	
	
		public int dislikeCounter(int y){
			connectDB();
	    	SQL_statement =" SELECT COUNT(*) FROM Dislikes WHERE message_id="+y+";";
	    	try {
				if (conn != null ){
					st = conn.createStatement();
					rs = st.executeQuery(SQL_statement);
					int d = rs.getInt("COUNT");
					st.close();
					rs.close();
					conn.close();
					return d;
		        }
			}catch (SQLException e) {
				System.out.println("SQL statement exception" + e);
			}
		}
	
	
	
		public void updateDislikes(String username, String dislikedname, int y) {
			connectDB();
			SQL_statement = "INSERT INTO Dislikes(message_id,disliked_user,disliker) VALUES('"+y+"','"+dislikedname+"','"+username+"');";
			try {
				if (conn != null ) {
					st = conn.createStatement();
					st.executeUpdate(SQL_statement);
					st.close();
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("SQL statement exception" + e);
			}
		}
	
	
		public void connectDB(){
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
						+ "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");
			} catch (SQLException e) {
						System.err.println("Connection failed");
			}
		}
	
	
	
}
