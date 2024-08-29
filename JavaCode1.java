package company;

import java.sql.*;

public class basic 
{

	public static void main(String[] args) 
	{
		try 
		{
			// 1st Step
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver is loaded");
			
			
			// 2nd Step
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Git?user=postgres&password=root");
			System.out.println("Connection is created between database and java application");
			
			
			// 3rd Step
			Statement st = con.createStatement();
			System.out.println("Statement is created");
			
			
			// 4th Step
			//  ways to add the data in database using : 1.addBatch() and 2. execute() 
		
			st.addBatch("insert into industries values (1001,'Shubh Private Ltd', 2.3)");
			st.addBatch("insert into industries values (1002,'Abhay Logistics', 3.9)");
			st.addBatch("insert into industries values (1003,'Ankush Gateways', 5.1)");
		
			st.executeBatch();
			
			st.execute("insert into industries values (1004, 'Sharvari Tech ', 4.3)");
			st.executeUpdate("update industries set name = 'Sharvari InfoTech' where id = '1004'");
			
			System.out.println("Data is inserted");
			
			
			// 5th Step
			con.close();
			System.out.println("Connection is closed");
			
			
		}
		
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
	}

}
