package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicketWithDataProviderTest {


	@Test(dataProvider = "dataprovider_bookTicketWith2D" )
	public void bookTicketWith2D(String src, String dst ) {
		System.out.println(" Book ticket from "+src+" to "+dst);
	}

	@DataProvider
	public Object[][] dataprovider_bookTicketWith2D() {
		Object[][] objArr = new Object[3][2];

		objArr[0][0]= "Bangalore";
		objArr[0][1]= "Mysore";

		objArr[1][0]= "Bangalore";
		objArr[1][1]= "Managlore";

		objArr[2][0]= "Bangalore";
		objArr[2][1]= "Goa";

		return objArr;
	}

}


