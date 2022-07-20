package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {

		Connection conn=null;
		int result = 0;
		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");
			Statement stat = conn.createStatement();
			String query = "insert into employee_info values('7','cam','chandu','s')";
			result = stat.executeUpdate(query);
		} catch (Exception e) {
		}
		finally {
			if(result==1)
			{
				System.out.println("Values inserted succesfully");
			}
			else
			{
				System.err.println("Values is not inserted");
			}
		}
	}

}
