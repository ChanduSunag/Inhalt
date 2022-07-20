package com.crm.myriad.genericlibrary;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author chandan
 */

public class FileLibrary implements IConstantLibrary {

	/**
	 * it's used to read the data from Property File based on the Key which you pass as an argument
	 * @param key
	 * @throws Throwable 
	 */

	public String getPropertyKeyValue(String key)  throws Throwable 
	{
		FileInputStream fis = new FileInputStream(FILEPATH);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;

	}

}
