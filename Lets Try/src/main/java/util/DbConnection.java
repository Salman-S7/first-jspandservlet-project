package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbConnection {
	public static Connection getConnection() {
		String url = "jdbc:mysql://localhost:3306/try";
		String username = "root";
		String password = "shaikh0099";
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url,username,password);
			System.out.println("connected22");
			//String query = "insert into users(name,password,email,gender,course) values(?,?,?,?,?)";
			
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
		return connection;
	}
}
