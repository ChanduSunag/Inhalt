package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadSpecificDataAndVerifyFromExcelTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("ExampleData");
		String expectedData = "Iphone";
		int count = sheet.getLastRowNum();
		for(int i=0;i<count;i++)
		{
			Row row= sheet.getRow(i);
			String actualData = row.getCell(0).getStringCellValue();

			if(expectedData.equals(actualData))
			{
				String nextData = row.getCell(1).getStringCellValue();
				System.out.println("Available Data is "+nextData);
			}

		}

	}

}
