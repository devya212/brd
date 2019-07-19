package com.nucleus.error;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class ErrorLog {
	FileWriter filewriter = null;
	PrintWriter printwriter = null;
	
	public void SaveToFile(String line,String s)
	{
		
		try {
			filewriter = new FileWriter("Error21.txt",true); //text file for error log created
			printwriter= new PrintWriter(filewriter);
			printwriter.write(line +" "+s +"\n" ); //storing error records
			printwriter.flush();
			System.out.println(" file created");
		} catch (IOException e) {

			e.printStackTrace();
		}
		finally
		{
			try
			{
				filewriter.close(); 
				printwriter.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
}
