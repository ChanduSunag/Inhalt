package com.crm.myriad.genericlibrary;

import java.util.Date;
import java.util.Random;

/**
 * @author chandan
 */

public class JavaLibrary {

	/**
	 * it's used to generate random number
	 * @return intRandom
	 */

	public  int getRandomNumber()
	{
		Random random=new Random();
		int intRandom = random.nextInt(1000);
		return intRandom;
	}

	/**
	 * it's used to get system date and time in IST format
	 * @return 
	 * @return intDate
	 */

	public String getSystemDateAndTime() 
	{	
		Date date=new Date(0);
		String intDate = date.toString();
		return intDate;
	}
}
