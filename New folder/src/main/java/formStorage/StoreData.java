package formStorage;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class StoreData
 */
public class StoreData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String mail = request.getParameter("mail");
		String gender= request.getParameter("gender");
		String number= request.getParameter("number");
		String password = request.getParameter("password");
		
		try {
			final String url = "jdbc:mysql:///form";
			final String user = "root";
			final String pass = "root123";
			
			//establish connection
			Connection conn = DriverManager.getConnection(url,user,pass);
			
			PreparedStatement ps = conn.prepareStatement("insert into user_details values(?,?,?,?,?)");
			
			ps.setString(1,name);
			ps.setString(2, mail);
			ps.setString(3,gender);
			ps.setString(4, number);
			ps.setString(5,password);
			
			int i = ps.executeUpdate();
			 if(i > 0) {
			        System.out.println("You are registered successfully");
			      }		
			 
			 
			 conn.close();
				ps.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
