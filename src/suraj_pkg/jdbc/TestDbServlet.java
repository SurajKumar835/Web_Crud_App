package suraj_pkg.jdbc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import java.sql.*;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String user="hbstudent";
		String pass="hbstudent";
		String jdbcUrl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String driver="com.mysql.jdbc.Driver";
		try {
			PrintWriter out=response.getWriter(); 
			out.println("connection to database: "+jdbcUrl);
			Class.forName(driver);
			Connection myconn=DriverManager.getConnection(jdbcUrl, user, pass);
			out.println("Successful Connection "+myconn);
			myconn.close();
		}catch(Exception e) {
			e.printStackTrace();			
		}
	}

}
