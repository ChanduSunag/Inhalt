package sampleTestNG;

import org.testng.annotations.Test;


public class SampleProductTest {


	@Test(groups = "smoke test")
	public void createProductTest() {
		System.out.println("==========product created==========");
	}

	@Test(groups = "regression test")
	public void editProductTest() {
		System.out.println("==========edit product==========");
	}
}


