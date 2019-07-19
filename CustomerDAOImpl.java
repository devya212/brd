package com.nucleus.hp1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//import com.nucleus.connection.Connection1;
//import com.nucleus.connection.Connectionclass;
//import com.nucleus.connection.FactoryCon;
import com.nucleus.connection.Oracle;
import com.nucleus.validation.*;
import com.nucleus.error.*;


import com.nucleus.pojo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	Customer customer = new Customer();

	Validation validation = new Validation(); //object of validation class
	ErrorLog error = new ErrorLog();          //object of errorlog class
	Oracle connectionSetup = new Oracle();
	Connection con = connectionSetup.getConnection();
	PreparedStatement ps;

	public void readFromFile(String path, String rejection,Connection conn)
	{
		int errorcount = 0;
		FileReader filereader;
		try {
			filereader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(filereader);

			String line = bufferedReader.readLine();

			while (line != null) {

				String separate[] = line.split("~", -1);
				if (validation.checkpincode(separate[4]))         //checking pincode
				{
					
					customer.setCustomerPinCode(separate[4]);
				} 
				else {
					errorcount++;
					System.out.println("ERROR  IN CUSTOMER PIN CODE");
					String s="ERROR  IN CUSTOMER PIN CODE";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				if (validation.checkcode(separate[0])) {  //checking customer code
					
					customer.setCustomerCode(separate[0]);
				} else {
					errorcount++;
					System.out.println("ERROR  IN CUSTOMERCODE");
					String s="ERROR  IN CUSTOMERCODE";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				if (validation.checkaddress(separate[2])) {              //checking address
					customer.setCustomerAddress1(separate[2]);
				} else {
					errorcount++;
					System.out.println("ERROR  IN CUSTOMER ADDRESS");
					String s="ERROR  IN CUSTOMER ADDRESS";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				if (validation.checkprimarycontactperson(separate[7])) {      //checking primary contact person
					customer.setPrimaryContactPerson(separate[7]);
				} else {
					errorcount++;
					System.out.println("ERROR  IN CUSTOMER PRIMARY CONTACT PERSON");
					String s="ERROR  IN CUSTOMER PRIMARY CONTACT PERSON";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}

				if (validation.checkcreatedate(separate[10])) {          //checking create date
					customer.setCreateDate(separate[10]);
				} else {
					errorcount++;
					System.out.println("ERROR  IN CREATE DATE");
					String s="ERROR  IN CREATE DATE";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}

				if (validation.checkcreatedby(separate[11])) {         //checking date created by
					customer.setCreatedBy(separate[11]);
				} else {
					errorcount++;
					System.out.println("ERROR  IN CREADTED BY");
					String s="ERROR  IN CREADTED BY";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				
				if (validation.checkRecord(separate[8])) {         //checking record status
					customer.setRecordStatus(separate[8]);
				} else {
					errorcount++;
					System.out.println("ERROR IN RECORD STATUS");
					String s="ERROR IN RECORD STATUS";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				if (validation.checkFlag(separate[9])) {               //checking Active/Inactive flag status
					customer.setActiveInactiveFlag(separate[9]);
				} else {
					
					errorcount++;
					System.out.println("ERROR IN Active/Inactive FLAG");
					String s="ERROR IN Active/Inactive FLAG";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				if (validation.checkEmailId(separate[5])) {          //checking email id
					customer.setEmailaddress(separate[5]);
				} else {
					errorcount++;
					System.out.println("ERROR IN EMAIL ID");
					String s="ERROR IN EMAIL ID";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				if (validation.checkName(separate[1])) {               //checking customer name
					customer.setCustomerName(separate[1]);
				} else {
					errorcount++;
					System.out.println("ERROR IN CUSTOMER NAME");
					String s="ERROR IN CUSTOMER NAME";
					error.SaveToFile(line,s);
					line = bufferedReader.readLine();

				}
				customer.setCustomerAddress2(separate[3]);
				customer.setContactNumber(separate[6]);
				customer.setModifiedDate(separate[12]);
				customer.setModifiedBy(separate[13]);
				customer.setAuthorizedDate(separate[14]);
				customer.setAuthorizedBy(separate[15]);
				line = bufferedReader.readLine();

}
			System.out.println("error count: "+errorcount);          //number of errors
			bufferedReader.close();
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		if(conn!=null)                                           //if database connected
		{
			if(rejection.equalsIgnoreCase("F")&&(errorcount>0))   //checking rejection level
			{
				System.err.println("Rejection level is F. so could not load to database");
			}
			else{                                            
						try {
							InsertDetails(customer);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}}
		else                                                     //if database not connected
		{
			System.out.println("Database not connected");
			}
	}

	public void InsertDetails(Customer customer) throws SQLException {                                   //inserting data to database

		try {
			ps = con.prepareStatement("insert into customer_hp values(hp01.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, customer.getCustomerCode());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getCustomerAddress1());
			ps.setString(4, customer.getCustomerAddress2());
			ps.setString(5, customer.getCustomerPinCode());
			ps.setString(6, customer.getEmailaddress());
			ps.setString(7, customer.getContactNumber());
			ps.setString(8, customer.getPrimaryContactPerson());
			ps.setString(9, customer.getRecordStatus());
			ps.setString(10, customer.getActiveInactiveFlag());
			ps.setString(11, customer.getCreateDate());
			ps.setString(12, customer.getCreatedBy());
			ps.setString(13, customer.getModifiedDate());
			ps.setString(14, customer.getModifiedBy());
			ps.setString(15, customer.getAuthorizedDate());
			ps.setString(16, customer.getAuthorizedBy());
			ps.executeUpdate();
			System.out.println("saved");
		} catch (SQLException e) {
			e.printStackTrace();
		}
finally{
	
	//con.commit();
	ps.close();
	con.close();
}
	}
	
	

}
