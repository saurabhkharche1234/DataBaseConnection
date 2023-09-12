package connectionExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertIntoDataBaseUsingSimpleProg {

	public static void main(String[] args) throws SQLException {
		final String url = "jdbc:mysql:///employee";
		final String user = "root";
		final String password = "root123";
		
		//establish connection
		Connection conn = DriverManager.getConnection(url,user,password);
		
		//create a jdbc statement
		PreparedStatement ps = conn.prepareStatement("insert into employee_details values(?,?,?)");
	
		ps.setString(1,"Hinata");
		ps.setString(2, "5430996110");
		ps.setString(3,"Naruto");
		
		//execute query
		 int i = ps.executeUpdate();
		 if(i > 0) {
		        System.out.println("Data" + " is added successfully in the table.");
		      }		
		
		 // 5. Close Connection
		conn.close();
		ps.close();
		
		
	}

}
