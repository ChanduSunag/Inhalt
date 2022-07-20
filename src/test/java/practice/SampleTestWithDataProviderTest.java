package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTestWithDataProviderTest {


	@Test(dataProvider = "dataProvider_sampleTestWith3D")
	public void sampleTestWith3D( String src, String dst, int ticket) {
		System.out.println("Book ticket from "+src+" to "+dst+" for "+ticket+" members");
	}

	@DataProvider
	public Object[][] dataProvider_sampleTestWith3D() {
		Object[][] objArry= new Object[2][3];

		objArry[0][0] = "Bangalore";
		objArry[0][1] = "Goa";
		objArry[0][2] = 2;

		objArry[1][0] = "Bangalore";
		objArry[1][1] = "Pondicherry";
		objArry[1][2] = 2;
		return objArry;

	}

}
