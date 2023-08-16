package Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Connection connection = util.DbConnection.getConnection();
		//to check wheather email already exists if yes then 
		if(!isEmailUsed(connection,email)) {
			insertIntoDb(name,email,password,connection);
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}else {
			
			out.println("<h1>"+email+" is already used .. use another </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
			rd.include(request, response);
			

		}
		
		
	}

	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param connection
	 */
	private void insertIntoDb(String name, String email, String password, Connection connection) {
		try {
			String sql = "insert into user(name,email,password) values(?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,name);
			preparedStatement.setString(2,email);
			preparedStatement.setString(3,password);
			preparedStatement.executeUpdate();
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
	
	protected boolean isEmailUsed(Connection connection, String email) {
		boolean emailUsed = false;
		try {
			String sql = "select * from  user where email=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1,email);		
			ResultSet resultset = preparedStatement.executeQuery();					
			emailUsed = resultset.next();			
			System.out.println(emailUsed);
		
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return emailUsed;		
	}

}
