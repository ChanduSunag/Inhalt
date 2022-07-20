package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String url = book.getSheet("LoginData").getRow(0).getCell(1).getStringCellValue();
		String usn = book.getSheet("LoginData").getRow(1).getCell(1).getStringCellValue();
		String pwd = book.getSheet("LoginData").getRow(2).getCell(1).getStringCellValue();
		System.out.println(url);
		System.out.println(usn);
		System.out.println(pwd);

	}

}
