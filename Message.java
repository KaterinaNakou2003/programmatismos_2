package net.codejava.sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Message {

	Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    String SQL_statement = null;


	public void getConnectionWithDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
				"jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
				+ "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");;
		} catch (Exception exception) {
			System.out.println("DB Connection Exception " + exception);
		}
	}

	public String sendMessage(String username, String answer) {
		String message = null;
		getConnectionWithDB();
		if (!answer.equals("exit")) {
			message = username + " : " + answer;
			updateMessages( username, answer);
		} else {
			message = "ACTION CANCELLED";
		}
		return message;
	}// telos sendMessage


	public String getMessage(String user) {
		getConnectionWithDB();
		String message = null;
		SQL_statement = "SELECT TOP 1 message_id FROM Messages ORDER BY message_id DESC;";
		try {
			if (conn != null ) {
				st = conn.createStatement();
				ResultSet lastMessageOfDB = st.executeQuery(SQL_statement);// finds the number of the last message in db
				lastMessageOfDB.first();
				int nolmodb =lastMessageOfDB.getInt("message_id");
				st.close();
				lastMessageOfDB.close();
				//find last logout of user
				SQL_statement = "SELECT MAX(logout_id) FROM Logout WHERE username =" + "'"+ user +"'";
				try {
					if (conn != null ) {
						st = conn.createStatement();
						ResultSet lastLogout = st.executeQuery(SQL_statement);
						lastLogout.first();
						int noll = lastLogout.getInt("logout_id");
						int result = nolmodb - noll;
						message = user +"You have" + result + " new Messages \n You caught up with us!!";

						st.close();
						lastLogout.close();
						conn.close();
					}
				} catch (SQLException e) {
					message = "SQL statement exception" + e;
				}
			}
		} catch (SQLException e) {
			message = "SQL statement exception" + e;
		}
		return message;
	}//telos getMessage


	public String reply(String username, String answer, int numberOfMessage) {
		String message = null;
		getConnectionWithDB();
		if (!answer.equals("exit")) {
			updateMessages(username, answer);
			//prints message to user
			SQL_statement = "SELECT message_body,sender FROM Messages WHERE message_id = " + numberOfMessage;
			try {
				if (conn != null ) {
					st = conn.createStatement();
					rs = st.executeQuery(SQL_statement);
					rs.first();
					message = username + " replied to " + rs.getString("message_body") + " : " + answer ;
					st.close();
					rs.close();
					conn.close();
				}
			} catch (SQLException e) {
				message = "SQL statement exception" + e;
			}
		} else {
			message = "ACTION CANCELLED";
		}
		return message;
	}//telos reply

	public String printMessage() {
		System.out.println("Type your message");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		return message ;
   }

   public void updateMessages(String username, String answer) {
		SQL_statement = "INSERT INTO Messages(sender,message_body) VALUES ( '" + username + " ' , '" + answer + "')";
		try {
			if (conn != null ) {
				st = conn.createStatement();
				st.executeUpdate(SQL_statement);
				st.close();
			}
		} catch (SQLException e) {
			System.out.println("SQL statement exception" + e);
		}

   }

}//telos message
