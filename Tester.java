package com.nucleus.hp1;

import java.sql.Connection;
import java.util.Scanner;
import com.nucleus.connection.Connection1;
import com.nucleus.connection.Connectionclass;
import com.nucleus.connection.FactoryCon;
public class Tester {
	public static void main(String[] args) {
		String path = null;
		Scanner sc = new Scanner(System.in);
		
		CustomerDAOImpl customerdaoimp = new CustomerDAOImpl();
		
		Connection con=null;
		try
		{
			FactoryCon f=new FactoryCon();
		
		System.out.println("Enter database:"); //enter database you want to connect
		String database=sc.next();
		Connection1 connect1=f.getFactory(database);
		
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
		
		System.out.println("enter the file location"); //only file location
		String location = sc.next();
		System.out.println("enter the file name"); //finame with extension
		String filename = sc.next();

		if (filename.endsWith(".txt")) {
			path = location.concat("\\" + filename); // concatenating to obtain proper path 
		} else {
			System.out.println("enter the file in correct format");
		}
		System.out.println("Enter the rejection level");
		System.out.println("R.For Record level Rejection");
		System.out.println("F.For File level Rejection");
		String rejection = sc.next();
		customerdaoimp.readFromFile(path, rejection,con);

	}

}
