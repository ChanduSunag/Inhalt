package practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.myriad.genericlibrary.ExcelLibrary;

public class UsingDP_FetchDataFromExcelTest {

	@Test(dataProvider = "dataProvider_UsingDP_FetchDataFromExcel")
	public void UsingDP_FetchDataFromExcel ( String src, String dst, double ticket) {
		System.out.println("Book ticket from "+src+" to "+dst+" for "+ticket+" members");
	}



	ExcelLibrary eLib=new ExcelLibrary();

	@DataProvider
	public Object[][] dataProvider_UsingDP_FetchDataFromExcel() throws Throwable {
		Object[][] objArry= new Object[2][3];

		objArry[0][0] = eLib.getStringDataFromExcel("SampleDataProvider", 1, 0);
		objArry[0][1] = eLib.getStringDataFromExcel("SampleDataProvider", 1, 1);
		objArry[0][2] = eLib.getNumericDataFromExcel("SampleDataProvider", 1, 2);

		objArry[1][0] = eLib.getStringDataFromExcel("SampleDataProvider",2, 0);
		objArry[1][1] = eLib.getStringDataFromExcel("SampleDataProvider", 2, 1);
		objArry[1][2] = eLib.getNumericDataFromExcel("SampleDataProvider", 2, 2);
		return objArry;
	}


}



