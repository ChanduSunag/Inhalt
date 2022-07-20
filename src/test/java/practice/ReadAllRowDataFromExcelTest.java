package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ReadAllRowDataFromExcelTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Second");
		int count = sheet.getLastRowNum();
		for(int i=0;i<count;i++)
		{
			Row row = sheet.getRow(i);
			String firstColumn = row.getCell(0).getStringCellValue();
			String secondColumn = row.getCell(1).getStringCellValue();
			System.out.println(firstColumn+"\t"+secondColumn);
		}
	}
}
