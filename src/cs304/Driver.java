package cs304;

import java.sql.*;
import java.text.DateFormat;

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
	public ResultSet getRecord(String startDate, String endDate) {
		ResultSet rs = null;
		String query = "SELECT * FROM record";
		boolean where = false;
		if(!startDate.equals("")) {
			where = true;
			query += " where case_date >= '" + startDate + "'";
			if(!endDate.equals("")) {
				query += " and case_date <= '" + endDate + "'";
			}
		}
		System.out.println(query);
		try {
			rs = this.con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//Join query
	public ResultSet getRecordFilter(String startDate, String endDate, boolean homicide, boolean arson, boolean assault, boolean burglary,
											boolean publicS, boolean tax, boolean bribery, boolean extortion, boolean falseS, boolean theft) {
		ResultSet rs = null;
		boolean where = false;
		boolean crt = false;
		String query = "";
		if(homicide || arson || assault || burglary || publicS || tax || bribery || extortion || falseS || theft)
			crt = true;
		if(crt)
			query = "SELECT * FROM record INNER JOIN criminalRecordType crt ON crt.recordID = record.id";
		else
			query = "SELECT * FROM record";
		
		if(homicide) {
			if(!where) {
				query += " WHERE";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Homicide'";
		}
		if(arson) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Arson'";
		}
		if(assault) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Assault'";
		}
		if(burglary) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Burglary'";
		}
		if(publicS) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Public indecency'";
		}
		if(tax) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Tax Evasion'";
		}
		if(bribery) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Bribery'";
		}
		if(extortion) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Extortion'";
		}
		if(falseS) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'False Pretenses'";
		}
		if(theft) {
			if(!where) {
				query += " where";
				where = true;
			} else {
				query += " OR";
			}
			query += " crt.typeName = 'Theft'";
		}
		if(!startDate.equals("")) {
			if(crt) {
				query = "SELECT * FROM (" + query + ")";
			}
			query += " WHERE";
			query += " case_date >= '" + startDate + "'";
			if(!endDate.equals("")) {
				query += " and case_date <= '" + endDate + "'";
			}
		} else if(!endDate.equals("")) {
			if(crt) {
				query = "SELECT * FROM (" + query + ")";
			}
			query += " WHERE case_date <= '" + endDate + "'";
			
		}

		System.out.println(query);
		try {
			rs = this.con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
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
	//Delete without cascades - Case 1
	private ResultSet deleteRecord(String recordID) {
		ResultSet rs = null;
		String query = "delete from court where recordID = '" + recordID +"'";
		try {
			rs = this.con.createStatement().executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	//Delete with cascades - Case 2
	private ResultSet deleteTrial(int SIN) {
		ResultSet rs = null;
		String query = "delete from People where SIN = " + SIN;
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
		//ResultSet rs = currDriver.getRecord("2017-06-30", "2017-08-30", true, true, true, false);
		
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
