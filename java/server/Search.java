package server;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/Search")
public class Search extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String rollNumber = request.getParameter("rollNumber");
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_full_stack", "root", "optimus");
            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM students WHERE rollnumber=?");
            pstmt.setString(1, rollNumber);
            
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columns = rsMeta.getColumnCount();
            
            out.println("<html>");
            out.println("<head><title>Result</title></head>");
            out.println("<body>");
            out.println("<table border='1' cellspacing='0' cellpadding='5'>");
            out.println("<tr>");
            
            for (int i = 1; i <= columns; i++) {
                out.println("<th>" + rsMeta.getColumnName(i) + "</th>");
            }
            
            out.println("</tr>");
            
            while (rs.next()) {
                out.println("<tr>");
                for (int i = 1; i <= columns; i++) {
                    out.println("<td>" + rs.getString(i) + "</td>");
                }
                out.println("</tr>");
            }
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
