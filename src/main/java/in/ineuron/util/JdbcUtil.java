package in.ineuron.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil 
{		
		static {
			// Step1: loading and register the Driver
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException ce) {
				ce.printStackTrace();
			}
		}

		public static Connection getJdbcConnection() throws Exception
		{
			FileInputStream fis = new FileInputStream("C:\\Users\\jeysi\\EclipseForJavaDevandEnterprise\\CollegeLibraryManagementApplication\\src\\main\\java\\in\\ineuron\\util\\ApplicationProperties");
			Properties properties = new Properties();
			properties.load(fis);

			Connection connection = DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
			System.out.println("Object Has Been Created Succesfully ......");
			return connection;
		}
		
		public static void cleanUp(Connection con , Statement statement , ResultSet resultSet) throws SQLException
		{
			if(con != null) {
				con.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(resultSet != null) {
				resultSet.close();
			}
		}
		
		
	
}
