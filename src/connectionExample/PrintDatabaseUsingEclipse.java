package connectionExample;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrintDatabaseUsingEclipse {

   public static void main(String[] args) throws Exception {

      // variables
      final String url = "jdbc:mysql:///employee";
      final String user = "root";
      final String password = "root123";

      // establish the connection
      Connection con = DriverManager.getConnection(url, user, password);

      // create JDBC statement object
      Statement st = con.createStatement();

      // prepare SQL query
      String query = "SELECT * FROM employee_details";

      // send and execute SQL query in Database software
      ResultSet rs = st.executeQuery(query);

      // process the ResultSet object
      boolean flag = false;
      while (rs.next()) {
         flag = true;
         System.out.println(rs.getString(1) + " " + rs.getString(2) + 
                  " " + rs.getString(3));
      }

      if (flag == true) {
         System.out.println("\nRecords retrieved and displayed");
      } else {
         System.out.println("Record not found");
      }

      // close JDBC objects
      rs.close();
      st.close();
      con.close();

   } 
}