package net.codejava.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

	public static void main(String[] args) {
		try {
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
