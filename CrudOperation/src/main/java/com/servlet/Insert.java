package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  
	          response.setContentType("text/html");  
	          PrintWriter out = response.getWriter();  
	          
	          String name = request.getParameter("userName");  
	          String pwd = request.getParameter("userPass");  
	          String email = request.getParameter("userEmail");
	          String mobile = request.getParameter("userMobile");
	          String dob = request.getParameter("userDOB");  
	          String gender = request.getParameter("gender");  
	          String country =request.getParameter("userCountry");  
	          
	          try
	          {  
	               //load the driver
	               Class.forName("com.mysql.jdbc.Driver");  
	               //create connection object
	               Connection con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/ankit","root","root");  
	               // create the prepared statement object
	               PreparedStatement ps=con.prepareStatement("insert into registration values(?,?,?,?,?,?,?)");  
	  
	               ps.setString(1,name);  
	               ps.setString(2,pwd);  
	               ps.setString(3,email);  
	               ps.setString(4, mobile);
	               ps.setString(5,dob);  
	               ps.setString(6,gender);  
	               ps.setString(7,country); 
	              
	  
	               int i = ps.executeUpdate();  
	               if(i>0)  
	               out.print("You are successfully registered...");  
	               response.sendRedirect("Showdata");
	          }
	          catch (Exception ex)
	          {
	               ex.printStackTrace();
	          }  
	          out.close();  
	     }  

}
