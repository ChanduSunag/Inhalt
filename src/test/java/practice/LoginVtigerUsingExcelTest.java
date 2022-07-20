package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginVtigerUsingExcelTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream("./data/TestScriptData.xlsx");
		Workbook book=WorkbookFactory.create(fis);
		String url = book.getSheet("First").getRow(0).getCell(1).getStringCellValue();
		String usn = book.getSheet("First").getRow(1).getCell(1).getStringCellValue();
		String pwd = book.getSheet("First").getRow(2).getCell(1).getStringCellValue();

		WebDriver driver=new ChromeDriver();
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(usn);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();
		driver.close();
	}

}
