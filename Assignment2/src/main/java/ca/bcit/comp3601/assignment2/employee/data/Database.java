package ca.bcit.comp3601.assignment2.employee.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database
{
	private static String     url;
	private static String     user;
	private static String     password;
	private static Connection connection;
	
	
	public void init(final String driver, final String dbUrl, final String dbUser, final String dbPassword)
	{
		
		try
		{
			Class.forName(driver);
			url        = dbUrl;
			user       = dbUser;
			password   = dbPassword;
			connection = DriverManager.getConnection(url, user, password); 
		}
		catch(final ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	protected static Connection getConnection() throws SQLException
	{
		return connection;
	}
	
	public static void closeConnection()
	{
		if (connection != null)
		{
			try
			{
				connection.close();
				
				System.out.println("Database connection has been closed.");
			}
			catch (final SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
