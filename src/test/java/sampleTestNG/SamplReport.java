package sampleTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.myriad.genericlibrary.BaseClass;

public class SamplReport extends  BaseClass{
	
	@Test
	public void testA(){
		System.out.println("testA");
		Assert.fail();
		
	}
	
	@Test
	public void testB(){
		System.out.println("testB");
		
	}
	
	@Test
	public void testC(){
		System.out.println("testC");
		
	}

}
