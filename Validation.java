package com.nucleus.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.nucleus.pojo.Customer;

public class Validation {
	Customer customer = new Customer();
	
	public boolean checkName(String CustomerName)
	{
		if(CustomerName.matches("[a-zA-Z0-9 ]+")&&!CustomerName.isEmpty())
		{
			return true;
		}
		else
		return false;
	}
	public boolean checkcode(String CustomerCode)
	{
		if(!CustomerCode.isEmpty())
		{
			return true;
		}
		else
			return false;
				
	}
	public boolean checkaddress(String CustomerAddress1)
	{
		if(!CustomerAddress1.isEmpty())
		{
			return true;
		}
		else
			return false;
				
	}
	public boolean checkprimarycontactperson(String PrimaryContactPerson)
	{
		if((!PrimaryContactPerson.isEmpty())&&(PrimaryContactPerson.matches("[a-zA-Z0-9 ]+")))
		{
			return true;
		}
		else
			return false;
				
	}
	
	public boolean checkcreatedate(String CreateDate)
	{
		if(!CreateDate.isEmpty())
		{
			
			return true;
		}
		else
			return false;
				
	}
	public boolean checkcreatedby(String CreatedBy)
	{
		if(!CreatedBy.isEmpty())
		{
			return true;
		}
		else
			return false;
				
	}
	
	public boolean checkEmailId(String email)
	{
//		if(Emailaddress.contains("@")&&(Emailaddress.endsWith(".com"))|| Emailaddress.endsWith("co.in") || Emailaddress.endsWith("COM"))
//		{
//			return true;
//		}
		String emailRegex ="^[_a-zA-Z0-9-\\+]+(\\.[_a-zA-Z0-9-]+)*@[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9]+)*(\\.[a-zA-Z]{2,})$";
		 Pattern p= Pattern.compile(emailRegex);
		 Matcher matcher=p.matcher(email);
		 if(matcher.matches())
		 {
			 return true;
		 }
		 
		else if (email.equals(null) )
		{
			return false;
		}
		else
		return false;
		
	}
	public boolean checkpincode(String CustomerPinCode)
	{
		
		if(CustomerPinCode.length()==6)
		{
			return true;
		}
		else if(CustomerPinCode.equals(null))
		{
		return false;
		}
		else
		return false;
	}
	public boolean checkRecord(String RecordStatus)
	{
		
		if(RecordStatus.length()==1 && (RecordStatus.equals("N")|| RecordStatus.equals("M")|| RecordStatus.equals("D")||
				RecordStatus.equals("A")|| RecordStatus.equals("R")))
		{
			return true;
		}
		else if(RecordStatus.equals(null))
		{
		return false;
		}
		else
		return false;
	}

	public boolean checkFlag(String ActiveInactiveFlag)
	{
		
		if(ActiveInactiveFlag.length()==1 && (ActiveInactiveFlag.equals("A")||
				ActiveInactiveFlag.equals("I")))
		{
			return true;
		}
		else if(ActiveInactiveFlag.equals(null) )
		{
		return false;
		}
		else
		return false;
	}
}
