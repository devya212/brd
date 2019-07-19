package com.nucleus.connection;


	
import java.sql.Connection;


	public class FactoryCon 
	{
	public	Connection1 getFactory(String str)
		{
			if(str.equalsIgnoreCase("oracle"))
			{
				return  new Oracle();
			}
			/*else if(str.equalsIgnoreCase("mysql"))
			{
				return new MySql();
			}*/
			else
			{
				return null;
			}
		}

	}


