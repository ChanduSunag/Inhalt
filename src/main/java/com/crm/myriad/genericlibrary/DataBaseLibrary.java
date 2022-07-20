package com.crm.myriad.genericlibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

/**
 * @author chandan
 */

public class DataBaseLibrary implements IConstantLibrary {

	static Driver driver;
	static Connection connection;
	static ResultSet result;

	/**
	 * it's used to perform the MYSQL database connection
	 * @throws Throwable 
	 */

	public void connectToDataBase() throws Throwable {
		try {
			driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
		} 
		catch (Exception e) {
		}
	}

	/**
	 * it's used to execute the SELECT query 
	 * @param query
	 * @return result
	 * @throws Throwable
	 */

	public ResultSet executeQuery(String query) throws Throwable {	
		result = connection.createStatement().executeQuery(query);
		return result;		
	}

	/**
	 * it's is used to execute the NONSELECT query
	 * @param query
	 * @return result
	 * @throws Throwable
	 */

	public int executeUpdate(String query) throws Throwable {
		int result = connection.createStatement().executeUpdate(query);
		return result;
	}

	/**
	 * it's used to CLOSE the MYSQL database connection
	 * @throws Throwable
	 */

	public void closeDataBase() throws Throwable {
		try {
			connection.close();
		}
		catch (Exception e) {
		}
	}
}