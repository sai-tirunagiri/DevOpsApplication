package org.quinnox.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnectionFactory {
	private static Connection connection;
	public static String userName;
	public static String password;

	public static Connection getConnection() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded successfully!");
		connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/devOps","root","mysql");
		if(connection!=null){
			return connection;
		}
		else
		{
			return null;
		}
	}
}
