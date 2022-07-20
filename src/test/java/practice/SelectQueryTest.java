package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws SQLException {

		Connection conn=null;
		try{
			Driver driverRef=new Driver();

			//Register to the database
			DriverManager.registerDriver(driverRef);
			//connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			//create query statement
			Statement stat = conn.createStatement();
			//String query = "select * from employee_info";
			//execute the query
			ResultSet resultset = stat.executeQuery("select * from employee_info");
			while(resultset.next())
			{
				System.out.println(resultset.getInt(1)+"\t"+resultset.getString(2)+"\t"+resultset.getString(3)+"\t"+resultset.getString(4));
			}}
		catch (Exception e){

		}
		finally {

			conn.close();
		}

	}

}
