package cs304;

import java.sql.*;

public class Driver {

	public static String connectionURL = "jdbc:oracle:thin:@localhost:1522:ug";
	public static String userName = "ora_k0b9";
	public static String password = "a52043122";
	
	private static Driver driver;
	private Connection con;

	private Driver() {
		connect();
	}

	public static Driver getDriver() {
		if (driver == null) {
			driver = new Driver();
		}
		return driver;
		
	}
	
	public void connect() {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			this.con = DriverManager.getConnection(connectionURL, userName, password);
			
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getTest() {
		ResultSet rs = null;
		String query = "SELECT * FROM Record";
		try {
			rs = this.con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/* 
	 * Search and find queries
	 */

	//Selection and projection query
	public ResultSet getRecord(String startDate, String endDate, boolean homicide, boolean arson, boolean assult, boolean burgulary) {
		ResultSet rs = null;
		String query = "SELECT * FROM Record";
		try {
			rs = this.con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	//Join query
	
	
	//Division query

	
	//Aggregation query
	
	
	//Nested aggregation with group-by
	

	/*
	 * update & insert queries
	 */
	//Update with check constraint. Include the constraint in the code, but do it in the user interface as well
	
	
	
	
	/*
	 * delete queries
	 */
	//Delete with cascades - Case 1
	private ResultSet deleteRecord() {
		ResultSet rs = null;
		String query = "TODO";
		try {
			rs = this.con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//Delete without cascades - Case 2
	private ResultSet deleteTrial() {
		ResultSet rs = null;
		String query = "TODO";
		try {
			rs = this.con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	
	
	public static void main(String args[]) {
		Driver currDriver = getDriver();
		
		ResultSet rs = currDriver.getTest();
		try {
			while(rs.next()) {
				System.out.println("test :( ");
				System.out.println(rs.getString("ID"));
				System.out.println(rs.getString("DESCRIPTION"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
