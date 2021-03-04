package lesson10.lecture.jdbc.testsetup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.miu.mpp.qms.business.Quiz;

public class TestJavaDb {
	//queries
	String TEST_INSERT = "INSERT INTO CUSTOMER "+
						"(name,street,city,zip) "+       	
						"VALUES('Tommy','10 E. Washington Ave','Fairfield','52556')"; 
	String INSERT_QUIZ = "INSERT INTO QUIZ"+
			"(duration, startTime, endTime)"+
			"VALUES(22, )"
			;

	String TEST_UPDATE = "UPDATE CUSTOMER "+
						 "SET city = 'Mexico' "+
						 "WHERE name = 'Tommy'";

	
	String TEST_READ = "SELECT * FROM CUSTOMER WHERE name='Tommy'";
	
	
	Connection con;
	Statement stmt;
	String dburl = "jdbc:derby://localhost/qms;create=true";
	String insertStmt = "";
	String selectStmt = "";
	String city = null;
	
	public static void main(String[] args) {
		TestJavaDb demo = new TestJavaDb();
		
		demo.insertExample();
		demo.readExample();
		demo.updateExample();
		demo.readExample();
		
		demo.closeConnection();
		
	}
	public TestJavaDb() {
		//load driver just once if necessary
		//not necessary for JavaDb 
		try {
			//Default username and password are "app" -- can be modified
			con = DriverManager.getConnection(dburl, "app", "app");
			System.out.println("Got connection...");
		}
		catch(SQLException e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	}
	void loadDriver() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
		}
		catch(ClassNotFoundException e){
			//debug
			e.printStackTrace();
		}
	}
	void closeConnection() {
		try {
			if(con !=null)
				con.close();
			System.out.println("Connection closed");
		}
		catch(SQLException ex) {
			System.out.println("Unable to close connection");
			ex.printStackTrace();
		}
		
	}
	void insertExample(){
		try {
			stmt = con.createStatement();
			
			System.out.println("insert query "+TEST_INSERT);
			stmt.executeUpdate(TEST_INSERT);
			stmt.close();
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
			
	}
	
	
	
	void readExample(){
		
		
		try {
			stmt = con.createStatement();
			System.out.println("the query: "+TEST_READ);
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if(rs.next()){
				String id = rs.getString("id");
				String name = rs.getString("name");
				city = rs.getString("city");
				String zip = rs.getString("zip");
				System.out.println("id: "+ id + " name: "+name+ "city: "+city + " zip: " + zip);
			}
			else {
				System.out.println("No records found");
			}
			stmt.close();
			
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		
		
		
		
	}
	void updateExample(){
		try {
			stmt = con.createStatement();
			
			System.out.println("update query "+TEST_UPDATE);
			stmt.executeUpdate(TEST_UPDATE);
			stmt.close();
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
		//check result
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(TEST_READ);
			if(rs.next()){
				String newcity = rs.getString("city");
				System.out.println("old city: " + city + " new city: " + newcity);
			}
			else {
				System.out.println("No records found");
			}
			stmt.close();
			
		}
		catch(SQLException s){
			s.printStackTrace();
		}
					
		
	}
	void insertQuiz(Quiz quiz){
		try {
			stmt = con.createStatement();
			
			System.out.println("insert query "+TEST_INSERT);
			stmt.executeUpdate(TEST_INSERT);
			stmt.close();
					
		} 
		catch (SQLException ex) {
			System.err.println("SQLQueryException: " + ex.getMessage());
		}
			
	}
	
	void inert(Quiz quiz) throws SQLException {
		//Creating a Prepared Statement
	      String query = "INSERT INTO quiz VALUES (?, ?, ?)";
	      PreparedStatement pstmt = con.prepareStatement(query);
	      pstmt.setString(1, quiz.getDuration()+"");
	      pstmt.setObject(2, quiz.getStartTime());
	      pstmt.setObject(3, quiz.getEndTime()+"");
	      pstmt.execute();
	      System.out.println("Rows inserted ....");
	      //Retrieving values
	      Statement stmt = con.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from quiz");
	      while(rs.next()) {
	         System.out.println("Quiz Duration: "+rs.getString("duration"));
	         System.out.println("Start Time: "+rs.getString("startTime"));
	         System.out.println("End Time: "+rs.getDate("endTime"));
	         System.out.println();
	      }
	}
	
}
