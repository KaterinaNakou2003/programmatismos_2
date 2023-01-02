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
		if (!answer.equals("exit")) {
			getConnectionWithDB();
			message = username + " : " + answer;
			updateMessages( username, answer, 0);
		} else {
			message = "ACTION CANCELLED";
		}
		return message;
	}// telos sendMessage


	public void getMessage(String user) {
		getConnectionWithDB();
		String message = null;
		SQL_statement = "SELECT TOP 1 message_id FROM Messages ORDER BY message_id DESC;";
		try {
			if (conn != null ) {
				st = conn.createStatement();
				ResultSet lastMessageOfDB = st.executeQuery(SQL_statement);// finds the number of the last message in db
				lastMessageOfDB.first();
				int nolmodb = lastMessageOfDB.getInt("message_id");
				st.close();
				lastMessageOfDB.close();
				//find last logout of user
				SQL_statement = "SELECT MAX(logout_id) FROM Logout WHERE username =" + "'"+ user +"'";
				try {
					st = conn.createStatement();
					ResultSet lastLogout = st.executeQuery(SQL_statement);
					lastLogout.first();
					int noll = lastLogout.getInt("logout_id");
					int result = nolmodb - noll;
					System.out.println("You have" + result + " new Messages \n Let's catch up!! ");
					st.close();
					lastLogout.close();
					SQL_statement = "SELECT message_id, sender, message_body, typeofmessage FROM Messages WHERE message_id>" + noll + ";";
					try {
						st = conn.createStatement();
						rs = st.executeQuery(SQL_statement);
						while(rs.next()){
							if (rs.getInt("typeofmessage") == 0) {
						   		System.out.println(rs.getString("sender") + " : " + rs.getString("message_body"));
							} else if (rs.getInt("typeofmessage") == -1) {
								//otan kanei like sth message tha mpainei -1
								System.out.println(rs.getString("sender") + " liked : " + rs.getString("message_body"));
							} else if (rs.getInt("typeofmessage") == -2) {
								//otan kanei dislike sth message tha mpainei -2
								System.out.println(rs.getString("sender") + " disliked : " + rs.getString("message_body"));
							} else {
								SQL_statement = "SELECT message_body,sender,typeofmessage FROM Messages WHERE message_id = " + rs.getInt("message_id");
								try {
									Statement st2 = conn.createStatement();
									ResultSet rs2 = st.executeQuery(SQL_statement);
									rs2.first();
									String sender = rs2.getString("sender") + " replied to: ";
									String reply = " : " + rs2.getString("message_body");
									SQL_statement = "SELECT message_body FROM Messages WHERE message_id = " + rs2.getInt("typeofmessage");
									// an type 10 -> o user replied to 10o munhma, opote caxnv to message_body pou antistoixei se auton ton arithmo
									try {
										Statement st3 = conn.createStatement();
										ResultSet rs3 = st.executeQuery(SQL_statement);
										rs3.first();
										System.out.println(sender + rs3.getString("message_body") + reply);
										st3.close();
										rs3.close();
									} catch (SQLException e) {
										System.out.println("SQL statement exception" + e);
									}
									st2.close();
									rs2.close();
								} catch (SQLException e) {
									System.out.println("SQL statement exception" + e);
								}
							}// telos if
						}//telos while
						System.out.println("You're now ready... Have fun!");
						st.close();
						rs.close();
					} catch (SQLException e) {
						System.out.println("SQL statement exception" + e);
					}
				} catch (SQLException e) {
					System.out.println("SQL statement exception" + e);
				}
				conn.close();
			} // telos if conn != 0
		} catch (SQLException e) {
			System.out.println("SQL statement exception" + e);
		}
	}//telos getMessage


	public String reply(String username, String answer, int numberOfMessage) {
		String message = null;
		if (!answer.equals("exit")) {
			getConnectionWithDB();
			updateMessages(username, answer, numberOfMessage);
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

   public void updateMessages(String username, String answer, int type) {
		SQL_statement = "INSERT INTO Messages(sender,message_body,typeofmessage) VALUES ( '" + username + " ' , '" + answer + " ' , " + type + ")";
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
