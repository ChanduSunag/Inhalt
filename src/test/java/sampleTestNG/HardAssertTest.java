package sampleTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {


	@Test
	public void createContactTest() {
		System.out.println("step_1");
		System.out.println("step_2");
	//	Assert.assertEquals("A", "A");
		System.out.println("step_3");
		System.out.println("step_4");
	}

	
	@Test
	public void modifyContactTest() {
		System.out.println("step_5");
		System.out.println("step_6");
		System.out.println("step_7");
	}

}
