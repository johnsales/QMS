package lesson10.lecture.jdbc.testsetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectManager {
	
//	private static final String DB_URL 
//		= "jdbc:derby://localhost:1527/MPP_DB;create=true";
//	private static final String USERNAME = "app";
//	private static final String PASSWORD = "app";
	
	private static final String DB_URL = "jdbc:mysql://localhost/qms";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "P@sser123";
	/* replace with new Optional pattern
	private static Connection conn = null;
	public Connection getConnection() throws SQLException {
		if(conn == null) {	
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			System.out.println("Got connection...");
		}
		return conn;
	}
	*/
	
	private Connection conn = null;
	private Connection myGetConn() {
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
			return conn;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Connection getConnection() {
		return Optional.ofNullable(conn).orElseGet(this::myGetConn);
	}
	
	public void closeConnection(Connection con)  throws SQLException {
		if(con != null && !con.isClosed()) {
			con.close();
		}
	}
}
