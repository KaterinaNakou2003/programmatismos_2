public class Likes {
	public String likedUser(String username,int y){
		connectWithDB();
		String lkduser = "SELECT sender FROM Messages WHERE message_id ="+ y;
		SQL_statement = "INSERT INTO Likes(message_id,liked_user,liker) VALUES('"+y+"','"+lkduser+"','"+username+"');";
		return lkduser;
		// update db
		try{
			st = conn.createStatement();
			st.executeUpdate(SQL_statement);
			st.close();
		}catch (SQLException e){
			System.out.println("SQL statement exception" + e)
		}
	}
	public int likeCounter(int y){
    	int d = "SELECT COUNT(*) FROM Likes WHERE message_id="+y;
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
		} catch(ClassNotFoundException cnfe){
			System.out.println("Error loading driver")
		}
	}
}
