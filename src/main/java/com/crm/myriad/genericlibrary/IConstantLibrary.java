package com.crm.myriad.genericlibrary;

/**
 * @author chandan
 * 
 * it's used to store all the constant values
 * @param EXCELPATH
 * @param FILEPATH
 * @param JDBC_URL
 * @param JDBC_USERNAME
 * @param IMPLICITLY_TIMEOUT
 * @param EXPLICITLY_TIMEOUT
 */

public interface IConstantLibrary {

	String EXCELPATH = "./data/TestScriptData.xlsx";
	String FILEPATH = "./data/commondata.properties";
	String JDBC_URL = "http://localhost:8888/";
	String JDBC_USERNAME = "root";
	String JDBC_PASSWORD ="root";
	int IMPLICITLY_TIMEOUT = 25;
	int EXPLICITLY_TIMEOUT = 25;
}
