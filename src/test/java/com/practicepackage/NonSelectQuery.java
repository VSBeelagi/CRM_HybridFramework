package com.practicepackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws Throwable {
		
		Connection con =null;
		int result = 0;
		try {
		Driver driver = new Driver();
		
		DriverManager.registerDriver(driver);
		
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet51", "root", "root");
		 
		 Statement state = con.createStatement();
		 
		 String query = "insert into project values('API', 'Sachin', 'Bangalore', 1),('Manual', 'Ashish', 'Bangalore', 1);";
		 
		 result = state.executeUpdate(query);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
		 
		if(result==2)
		 {
			 System.out.println("data is created");
		}
		 else {
			System.out.println("data is not present");
		}
		 con.close();
		}
	}
}

















