package server;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//step1 : Load or register your driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//step 2: Create connection object 
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java_full_stack","root","optimus");
			//step 3: create statement ot prepared statment
			PreparedStatement pstmt=con.prepareStatement("insert into students values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, request.getParameter("rollnumber"));
			pstmt.setString(2, request.getParameter("name"));
			pstmt.setString(3, request.getParameter("section"));
			pstmt.setInt(4, Integer.valueOf(request.getParameter("course1")));
			pstmt.setInt(5, Integer.valueOf(request.getParameter("course2")));
			pstmt.setInt(6, Integer.valueOf(request.getParameter("course3")));
			pstmt.setInt(7, Integer.valueOf(request.getParameter("course4")));
			pstmt.setInt(8, Integer.valueOf(request.getParameter("course5")));
			pstmt.setInt(9, Integer.valueOf(request.getParameter("course6")));
			pstmt.setInt(10, Integer.valueOf(request.getParameter("lab1")));
			pstmt.setInt(11, Integer.valueOf(request.getParameter("lab2")));
			
			int status=pstmt.executeUpdate();
			PrintWriter out=response.getWriter();
			if(status>0)
			{
				out.println("Inserted");
			}
			else
			{
				out.println("Problem with inertion");
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
