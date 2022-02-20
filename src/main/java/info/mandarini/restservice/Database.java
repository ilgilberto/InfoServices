package info.mandarini.restservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	public static Connection connection;

	public static void createConnection() {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver" );
			} catch (Exception e) {
			System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
			e.printStackTrace();
			return;
			}
			try {
				connection = DriverManager.getConnection(
						"jdbc:hsqldb:file:lib/data", "SA", "");
			connection.prepareStatement("create table X(int varchar(500))", 1);
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
