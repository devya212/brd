package com.nucleus.connection;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


	public class Oracle implements Connection1 {

		Connection conn=null;
		public Connection getConnection()
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				 conn=DriverManager.getConnection("jdbc:oracle:thin:@10.1.50.198:1521:orcl","sh","sh");
	               return conn;	
			}
			catch(Exception e)
			{System.out.println(e);
			
				}
			return conn;
			}
		public void closeConnection() {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}}

