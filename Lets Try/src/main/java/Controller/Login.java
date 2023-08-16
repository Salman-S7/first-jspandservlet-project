package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		if(isValidUser(email, password)) {
			//out.println("<h1>Welcome</h1>");
			HttpSession session = request.getSession();
			name = getName();
			session.setAttribute(name, name);
			
			response.sendRedirect("welcome.jsp");
			//response.sendRedirect("welcome.jsp");
			
			
		}else {
			out.println("<h1>the password you enterd was wrong</h1>");
			//response.sendRedirect("Login.jsp");

		}
		
	}

	private boolean isValidUser(String email, String password) {
		Connection connection = util.DbConnection.getConnection();
		boolean isValid = false;
		try {
			String sql = "select * from  user where email=? and password = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);
			ResultSet resultset = preparedStatement.executeQuery();
			
			
			isValid = resultset.next();
			
			System.out.println(isValid);
			String name =resultset.getString(1);
			connection.close();
			setName(name);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return isValid;
	}

}
