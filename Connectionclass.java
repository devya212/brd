package com.nucleus.connection;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;
	import java.util.Scanner;


	public class Connectionclass {

		public static void main(String ar[])
		{
			Connection con=null;
			try
			{
				FactoryCon f=new FactoryCon();
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter database:");
			String database=sc.next();
			Connection1 connect1=f.getFactory(database);
			//Connection1 connect1=f.getFactory("oracle");
		    con=connect1.getConnection();
			if(con!=null)
			{
				System.out.println("connected");
				
			}
			else
				System.out.println("not connected");
			}
			catch(Exception e)
			{
				System.out.println("not connected");
			}	
		}}
