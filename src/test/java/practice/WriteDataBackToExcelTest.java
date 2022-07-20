package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataBackToExcelTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		book.getSheet("LoginData").getRow(3).createCell(0).setCellValue("status");
		book.getSheet("LoginData").getRow(3).createCell(1).setCellValue("pass");


		FileOutputStream fos=new FileOutputStream("./data/TestData.xlsx");
		book.write(fos);
		book.close();
	}

}
