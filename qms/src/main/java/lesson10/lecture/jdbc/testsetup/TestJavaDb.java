package lesson10.lecture.jdbc.testsetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import edu.miu.mpp.qms.business.Quiz;

public class TestJavaDb {
	// queries
	String TEST_INSERT = "INSERT INTO CUSTOMER " + "(name,street,city,zip) "
			+ "VALUES('Tommy','10 E. Washington Ave','Fairfield','52556')";
	String INSERT_QUIZ = "INSERT INTO QUIZ" + "(duration, startTime, endTime)" + "VALUES(22, )";

	String TEST_UPDATE = "UPDATE CUSTOMER " + "SET city = 'Mexico' " + "WHERE name = 'Tommy'";

	String TEST_READ = "SELECT * FROM CUSTOMER WHERE name='Tommy'";

	Connection con;
	Statement stmt;
	String dburl = "jdbc:mysql://localhost/qms";
	String insertStmt = "";
	String selectStmt = "";
	String city = null;

	public static void main(String[] args) throws SQLException {
		TestJavaDb demo = new TestJavaDb();
		Quiz quiz = new Quiz();
		quiz.setDuration(2);
		quiz.setStartTime(LocalDateTime.of(2021, 2, 1, 0, 0));
		quiz.setEndTime(LocalDateTime.of(2021, 2, 1, 0, 0));

		demo.insert(quiz);
//		demo.insertExample();
//		demo.readExample();
//		demo.updateExample();
//		demo.readExample();

		demo.closeConnection();

	}

	public TestJavaDb() {
		// load driver just once if necessary
		// not necessary for JavaDb
		try {

			// Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			// Default username and password are "app" -- can be modified
			con = DriverManager.getConnection(dburl, "root", "P@sser123");
			System.out.println("Got connection...");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	void loadDriver() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch (ClassNotFoundException e) {
			// debug
			e.printStackTrace();
		}
	}

	void closeConnection() {
		try {
			if (con != null)
				con.close();
			System.out.println("Connection closed");
		} catch (SQLException ex) {
			System.out.println("Unable to close connection");
			ex.printStackTrace();
		}

	}

	void insertExample() {
		try {
			stmt = con.createStatement();

			System.out.println("insert query " + TEST_INSERT);
			stmt.executeUpdate(TEST_INSERT);
			stmt.close();

		} catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}

	}

	void readExample() {

		try {
			stmt = con.createStatement();
			System.out.println("the query: " + TEST_READ);
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				city = rs.getString("city");
				String zip = rs.getString("zip");
				System.out.println("id: " + id + " name: " + name + "city: " + city + " zip: " + zip);
			} else {
				System.out.println("No records found");
			}
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	void updateExample() {
		try {
			stmt = con.createStatement();

			System.out.println("update query " + TEST_UPDATE);
			stmt.executeUpdate(TEST_UPDATE);
			stmt.close();

		} catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		// check result
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if (rs.next()) {
				String newcity = rs.getString("city");
				System.out.println("old city: " + city + " new city: " + newcity);
			} else {
				System.out.println("No records found");
			}
			stmt.close();

		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	void insertQuiz(Quiz quiz) {
		try {
			stmt = con.createStatement();

			System.out.println("insert query " + TEST_INSERT);
			stmt.executeUpdate(TEST_INSERT);
			stmt.close();

		} catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}

	}

	void insert(Quiz quiz) throws SQLException {
		// Creating a Prepared Statement
		try {
			String query = "INSERT INTO quiz(duration, startTime, endTime) VALUES (?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, quiz.getDuration() + "");
			pstmt.setObject(2, quiz.getStartTime());
			pstmt.setObject(3, quiz.getEndTime() + "");
			pstmt.execute();
			System.out.println("Rows inserted ....");
			// Retrieving values
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from quiz");
			while (rs.next()) {
				System.out.println("Quiz Duration: " + rs.getString("duration"));
				System.out.println("Start Time: " + rs.getString("startTime"));
				System.out.println("End Time: " + rs.getDate("endTime"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
