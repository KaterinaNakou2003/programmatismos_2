public class Dislikes {

	public String dislikedUser(String username,int y){

			connectWithDB();
			String dislkduser = "SELECT sender FROM Messages WHERE message_id = y;";
			SQL_statement = "INSERT INTO Dislikes(message_id,disliked_user,disliker) VALUES('"+y+"','"+dislkduser+"','"+username+"');";
			return dislkduser;
			// update db
			try{
				st = conn.createStatement();
				st.executeUpdate(SQL_statement);
				st.close();
			}catch (SQLException e){
				System.out.println("SQL statement exception" + e);
			}

		}

		public int dislikeCounter(int y){
	    	int d = "SELECT COUNT(*) FROM Dislikes WHERE message_id=y;";
	    	return d;

		}


		public void connectWithDB(){
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection conn = DriverManager.getConnection(
						"jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
						+ "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");
				System.out.println("Yay, we connected it!");
			} catch (SQLException e) {
						System.err.println("Connection failed");
						e.printStackTrace();
			}
		}
}

