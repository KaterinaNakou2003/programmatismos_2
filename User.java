package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;


public class User {



	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
   		ResultSet rs = null;
   		String SQL_statement;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(
				"jdbc:sqlserver://DESKTOP-NVDOEDC:1433;"
				+ "DatabaseName=Codecom;encrypt=true;trustServerCertificate=true;", "Progr2", "programmatismos2");;
		} catch (Exception exception) {
			System.out.println("DB Connection Exception " + exception);
		}
		String username = null;
		Scanner input = new Scanner(System.in);
		Account account = new Account();
		Message message = new Message();
		Logout logout = new Logout();

		boolean flag = false;
		int x;

		while(true) {
			System.out.println("Welcome to Codecom");
			System.out.println("Press 1 to SignUp or 2 to SignIn");

			try {
				x = input.nextInt();
				break;
			} catch(Exception wException) {
			  	System.out.println("There was a mismatch");
				input.nextLine();
			}
		}

		if(x==1) {
			account.setUsername();
			account.setPassword();


			if (account.checkUsername(account.getUsername())) {
				System.out.println ("This username already exists");
			  	System.out.println ("Try again");
			  	account.setUsername();
			  	account.setPassword();
			} else {
				int result = account.addAccount(account.getUsername(),account.getPassword());


			 	 if (result==1) {
					username = account.getUsername();
					System.out.println("Welcome " + username);
					System.out.println("\n\n\n\n\n\n\n\n\n\n");
					System.out.println("--INSTRUCTIONS for beginners-- ");
					System.out.println("Change of mind? \n For action 1 to 4 if you want to back out type exit and then press enter in the body text");
					System.out.println("Please, do not try to find another way to back out so as for CodeCom to	fuction properly... \n Help us Help you!!");
					System.out.println("\n\n\n\n\n\n\n\n\n\n");
			  	} else {
					System.out.println("Person not added:Error");
				}
			}

		} else {
			account.setUsername();
			account.setPassword();
			if (account.verifyAccount(account.getUsername(),account.getPassword()) == true) {
				username=account.getUsername();
				System.out.println("Sign In Successfull");
				System.out.println("Hello " + username +". Have fun!" );
				System.out.println(message.getMessage(username));
			} else {
				System.out.println("Account not found");
			}
		}

		int action=0, y;
		String answer;
		System.out.print( "\n What do you want to do: \n 1.Send a message \n 2.Like a message \n 3.Dislike a message \n 4.Reply to message \n 5.Logout \n 6.Instructions \n");

		while (action != 5 || flag != true) {
			if (action==1) {
				answer = message.printMessage();
				System.out.println(message.sendMessage(username,answer));
			} else if (action==2) {
				System.out.println("Type the number of the message you want to like: ");
				y = input.nextInt();
				SQL_statement = "SELECT TOP 1 message_id FROM Messages ORDER BY message_id DESC;";
				try {
					if (conn != null ) {
						st = conn.createStatement();
						rs = st.executeQuery(SQL_statement);// finds the last message in db
						rs.first();
						if (rs.getInt("message_id") >= y) {
							//message.likeMessage(username, y);
						} else {
							System.out.println("ERROR!! We cannot find the message you want to reply to.");
						}
					}
					st.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("SQL statement exception" + e);
				}
				System.out.println();
			} else if (action==3) {
				System.out.println("Type the number of the message you want to dislike: ");
				y = input.nextInt();
				SQL_statement = "SELECT TOP 1 message_id FROM Messages ORDER BY message_id DESC;";
				try {
					if (conn != null ) {
						st = conn.createStatement();
						rs = st.executeQuery(SQL_statement);// finds the last message in db
						rs.first();
						if (rs.getInt("message_id") >= y) {
							//message.dislikeMessage(username, y);
						} else {
							System.out.println("ERROR!! We cannot find the message you want to reply to.");
						}
					}
					st.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("SQL statement exception" + e);
				}
				System.out.println();
			} else if (action==4) {
				System.out.print("Type the number of the message you want to reply to: ");
				 y = input.nextInt();
				SQL_statement = "SELECT TOP 1 message_id FROM Messages ORDER BY message_id DESC;";
				try {
					if (conn != null ) {
						st = conn.createStatement();
						rs = st.executeQuery(SQL_statement);// finds the last message in db
						rs.first();
						if (rs.getInt("message_id") >= y) {
							answer = message.printMessage();
							System.out.println(message.reply(username, answer, y));
						} else {
							System.out.println("ERROR!! We cannot find the message you want to reply to.");
						}
					}
					st.close();
					rs.close();
				} catch (SQLException e) {
					System.out.println("SQL statement exception" + e);
				}
			} else if (action == 6 ) {
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
				System.out.println("--INSTRUCTIONS-- ");
				System.out.println("Change of mind? \n For action 1 to 4 if you want to back out type exit and then press enter in the body text");
				System.out.println("Please, do not try to find another way to back out so as for CodeCom to	fuction properly... \n Help us Help you!!");
				System.out.println("\n\n\n\n\n\n\n\n\n\n");
			} else if (action == 5 ) {
				System.out.println(" Are you sure you want to logout; (Y/N) ");
				answer = input.next();
				flag = logout.getLogout(answer);
			}

			if (flag != true) { // mporei panv na egine true alla am janarvthsv ti na kanei kai allajei den tha teelivsei o vroxos
				System.out.println("What do you want to do next;");
				action = input.nextInt();
			}
		} // telos while

		// everytime a user logs out from codecom we save the number of the last message of db
		SQL_statement = "SELECT TOP 1 message_id FROM Messages ORDER BY message_id DESC;";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SQL_statement);
			rs.first();
			int nors = rs.getInt("message_id");// finds the number of the last message in db
			SQL_statement = "INSERT INTO Logout(username, lastmessageseen) VALUES( '" + username + " ' , " + nors + ");";
			rs.close();
			st.close();
			try {
				st = conn.createStatement();
				st.executeUpdate(SQL_statement); // inserts in table logout the number of this last message
				st.close();
			} catch (SQLException e) {
				System.out.println("SQL statement exception" + e);
			}

		} catch (SQLException e) {
			System.out.println("SQL statement exception" + e);

		}

	} // telos main

} // telos user
