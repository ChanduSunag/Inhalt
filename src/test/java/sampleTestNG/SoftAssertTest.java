package sampleTestNG;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {

	@Test
	public void createOrgTest() {
		
		System.out.println("step_1");
		System.out.println("step_2");
		SoftAssert s = new SoftAssert();
		//s.assertEquals("A", "B");
		System.out.println("step_3");
		//s.assertEquals("X", "Y");
		System.out.println("step_4");
		s.assertAll();
		}
	
		@Test
		public void modifyCustomerTest(){
		System.out.println("step_5");
		System.out.println("step_6");
		System.out.println("step_7");
		System.out.println("step_8");

	}
	
	
}
