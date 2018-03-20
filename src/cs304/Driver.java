package cs304;

import java.sql.*;

public class Driver {

	public static String connectionURL = "jdbc:oracle:thin:@localhost:1522:ug";
	public static String userName = "ora_x0x0";
	public static String password = "a11111111";
	
	public static void main(String args[]) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			
			Connection con = DriverManager.getConnection(connectionURL, userName, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from employees");
			
			while(rs.next()) {
				System.out.println(rs.getString("last_nanme"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
