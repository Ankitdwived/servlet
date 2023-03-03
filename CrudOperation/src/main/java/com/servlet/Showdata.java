package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Showdata
 */
@WebServlet("/Showdata")
public class Showdata extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Showdata() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		
		
		  
		  response.setContentType("text/html;charset=UTF-8");
		  PrintWriter out = response.getWriter();

		
		  try {

			  Class.forName("com.mysql.jdbc.Driver");  
		         //create connection object
		         Connection connection=DriverManager.getConnection( "jdbc:mysql://localhost:3306/ankit","root","root"); 
  PreparedStatement  preparedStatement = connection.prepareStatement( "select * from registration");
		   ResultSet resultSet = preparedStatement.executeQuery();

		   out.println("<html><body><h2>The Select query has following results : </h2>");
		   out.println("<hr></br><table cellspacing='0' cellpadding='5' border='1'>");
		   out.println("<tr>");
		   out.println("<td><b>Name</b></td>");
		   out.println("<td><b>Password</b></td>");
		   out.println("<td><b>Email</b></td>");
		   out.println("<td><b>Mobile</b></td>");
		   out.println("<td><b>DOB</b></td>");
		   out.println("<td><b>Gender</b></td>");
		   out.println("<td><b>Country</b></td>");
		   out.println("</tr>");

		   while(resultSet.next()) {
		    out.println("<tr>");
		    out.println("<td>"+resultSet.getString(1) + "</td>");
		    out.println("<td>"+resultSet.getString(2) + "</td>");
		    out.println("<td>"+resultSet.getString(3) + "</td>");
		    out.println("<td>"+resultSet.getString(4) + "</td>");
		    out.println("<td>"+resultSet.getString(5) + "</td>");
		    out.println("<td>"+resultSet.getString(6) + "</td>");
		    out.println("<td>"+resultSet.getString(7) + "</td>");
		    out.println("</tr>");

		   }

		   out.println("</table></br><hr></body></html>");
		  }
		  catch (SQLException e) {
		   e.printStackTrace();
		   out.print(e);
		  } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  out.print(e);
		}
	}

}
